package com.teste.ampulheta.services;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.teste.ampulheta.domain.Project;
import com.teste.ampulheta.domain.Tempo;
import com.teste.ampulheta.domain.User;
import com.teste.ampulheta.domain.enums.Perfil;
import com.teste.ampulheta.repositories.ProjectRepository;
import com.teste.ampulheta.repositories.TempoRepository;
import com.teste.ampulheta.repositories.UserRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private TempoRepository tempoRepository;
	
	public void instantiateTestDatabase() {
		
		Project p1 = new Project(null,"projeto1","Este é o primeiro projeto teste");
		Project p2 = new Project(null,"projeto2","Este é o segundo projeto teste");
		
		User u1 = new User(null,"Diney","diney@teste.com.br","diney",pe.encode("123"));
		User u2 = new User(null,"Teste","teste@teste.com.br","teste",pe.encode("1234"));
		User u3 = new User(null,"Teste3","3@teste.com.br","teste",pe.encode("3"));
		
		Date entrada = new Date();
		Date saida = new Date();
				
		Tempo t1 = new Tempo(null, entrada,  saida,p1);
		Tempo t2 = new Tempo(null, entrada,  saida,p1);
		Tempo t3 = new Tempo(null, entrada,  saida,p2);
		
		//p1.getTempos().addAll(Arrays.asList(t1));
		//p2.getTempos().addAll(Arrays.asList(t2, t3));
	
		
		
		u3.addPerfil(Perfil.USUARIO);
		u1.addPerfil(Perfil.USUARIO);	
		u2.addPerfil(Perfil.ADMIN);		
		
		u1.getProjects().addAll(Arrays.asList(p1,p2));
		u2.getProjects().addAll(Arrays.asList(p2));
		p1.getUser_id().addAll(Arrays.asList(u1));
		
		
		projectRepository.saveAll(Arrays.asList(p1,p2));
	    userRepository.saveAll(Arrays.asList(u1,u2,u3));
	    tempoRepository.saveAll(Arrays.asList(t1,t2,t3));
		
	}

}
