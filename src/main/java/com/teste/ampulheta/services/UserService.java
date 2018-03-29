package com.teste.ampulheta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.teste.ampulheta.domain.User;
import com.teste.ampulheta.repositories.UserRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	
	
	public User insert(User obj) {
		obj.setUser_id(null);
		pe.encode(obj.getPassword());
		return repo.save(obj);
	}
	
	public User findById(Integer user_id) throws ObjectNotFoundException {
		Optional<User> obj = repo.findById(user_id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não em comtrado!"));
	}
	
}
