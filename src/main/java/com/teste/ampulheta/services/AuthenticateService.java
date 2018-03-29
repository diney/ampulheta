package com.teste.ampulheta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.ampulheta.repositories.AuthenticateRepository;

@Service
public class AuthenticateService {
	
	@Autowired
	private AuthenticateRepository repo;

}
