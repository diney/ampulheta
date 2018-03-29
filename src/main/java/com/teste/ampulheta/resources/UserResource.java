package com.teste.ampulheta.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.teste.ampulheta.domain.User;
import com.teste.ampulheta.services.UserService;

import javassist.tools.rmi.ObjectNotFoundException;
@RestController
@RequestMapping(value="/api/v1/user")
public class UserResource {
	
	@Autowired
	private UserService service;	
	
	@RequestMapping( method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody User obj){
		
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
		path("/{user_id}").buildAndExpand(obj.getUser_id()).toUri();
		return ResponseEntity.created(uri).build();		
	}
	
	@RequestMapping(value="/{user_id}", method=RequestMethod.GET)
	public ResponseEntity<?> userById(@PathVariable Integer user_id) throws ObjectNotFoundException {			
		User obj = service.findById(user_id);			   
		return ResponseEntity.ok().body(obj);
	}

}
