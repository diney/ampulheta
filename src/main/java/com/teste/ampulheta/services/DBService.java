package com.teste.ampulheta.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.teste.ampulheta.domain.Project;
import com.teste.ampulheta.domain.User;
import com.teste.ampulheta.domain.enums.Perfil;
import com.teste.ampulheta.repositories.ProjectRepository;
import com.teste.ampulheta.repositories.UserRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProjectRepository projectRepository;
	
	public void instantiateTestDatabase() {
		
		Project p1 = new Project(null,"projeto1","Este é o primeiro projeto teste");
		Project p2 = new Project(null,"projeto2","Este é o segundo projeto teste");
		
		User u1 = new User(null,"Diney","diney@teste.com.br","diney",pe.encode("123"));
		User u2 = new User(null,"Teste","teste@teste.com.br","teste",pe.encode("1234"));
		u1.addPerfil(Perfil.USUARIO);	
		u2.addPerfil(Perfil.ADMIN);		
		
		u1.getProjects().addAll(Arrays.asList(p1,p2));
		u2.getProjects().addAll(Arrays.asList(p2));
		p1.getUser_id().addAll(Arrays.asList(u1));
		
		projectRepository.saveAll(Arrays.asList(p1,p2));
	    userRepository.saveAll(Arrays.asList(u1,u2));
		
	}

}
