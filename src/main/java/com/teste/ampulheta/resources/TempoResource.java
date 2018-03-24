package com.teste.ampulheta.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/tempos")
public class TempoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "REST está funfando!";
	}

}
