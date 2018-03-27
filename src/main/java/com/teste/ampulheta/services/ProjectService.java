package com.teste.ampulheta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.ampulheta.domain.Project;
import com.teste.ampulheta.repositories.ProjectRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository repo;
	
	public Project findById(Integer project_id) throws ObjectNotFoundException {
		Optional<Project> obj = repo.findById(project_id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não em comtrado!"));
	}
	
	public List<Project> findAll(){
		return repo.findAll();
	}


}
 