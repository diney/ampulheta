package com.teste.ampulheta.resources;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teste.ampulheta.domain.Project;
import com.teste.ampulheta.dto.ProjectDTO;
import com.teste.ampulheta.services.ProjectService;

import javassist.tools.rmi.ObjectNotFoundException;


@RestController
@RequestMapping(value="/api/v1/projects")
public class ProjectResource {
	
	
	@Autowired
	private ProjectService service;
	
	@RequestMapping(value="/{project_id}", method=RequestMethod.GET)
	public ResponseEntity<?> projectById(@PathVariable Integer project_id) throws ObjectNotFoundException {			
		Project obj = service.findById(project_id);			   
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping( method=RequestMethod.GET)
	public ResponseEntity<List<ProjectDTO>> projectGetAll()  {			
		List<Project> list = service.findAll();
		List<ProjectDTO> listDTO = list.stream().map(obj -> new ProjectDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	

	
}
