package com.teste.ampulheta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.ampulheta.domain.Tempo;
import com.teste.ampulheta.repositories.TempoRepository;

@Service
public class TempoService {
	
	@Autowired
	private TempoRepository repo;
	
	
	
	public List<Tempo> findByTempo(Integer Id) {
		return repo.findTempos(Id);
	}

}
