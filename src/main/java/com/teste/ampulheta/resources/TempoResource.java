package com.teste.ampulheta.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teste.ampulheta.domain.Tempo;
import com.teste.ampulheta.services.TempoService;

@RestController
@RequestMapping(value="/api/v1/time")
public class TempoResource {
	
	@Autowired
	private TempoService tempoService;
	
	@RequestMapping(value="/{project_id}", method=RequestMethod.GET)
	public ResponseEntity<List<Tempo>> findTempos(@PathVariable Integer project_id) {
		List<Tempo> list = tempoService.findByTempo(project_id);
		
		return ResponseEntity.ok().body(list);
	}
	


}
