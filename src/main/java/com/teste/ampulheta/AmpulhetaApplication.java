package com.teste.ampulheta;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.teste.ampulheta.domain.Project;
import com.teste.ampulheta.domain.User;
import com.teste.ampulheta.repositories.ProjectRepository;
import com.teste.ampulheta.repositories.UserRepository;

@SpringBootApplication
public class AmpulhetaApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProjectRepository projectRepository;

	public static void main(String[] args) {
		SpringApplication.run(AmpulhetaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Project p1 = new Project(null,"projeto1","Este é o primeiro projeto teste");
		Project p2 = new Project(null,"projeto2","Este é o segundo projeto teste");
		
		User u1 = new User(null,"Diney","diney@teste.com.br","diney","1234");
		User u2 = new User(null,"Teste","teste@teste.com.br","teste","4321");
		
		
		
		
		u1.getProjects().addAll(Arrays.asList(p1,p2));
		p1.getUser_id().addAll(Arrays.asList(u1));
		
		projectRepository.saveAll(Arrays.asList(p1,p2));
	    userRepository.saveAll(Arrays.asList(u1,u2));
		
		
	}
	
	
}
