package com.teste.ampulheta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teste.ampulheta.domain.Tempo;

@Repository
public interface TempoRepository extends JpaRepository<Tempo, Integer>  {
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Tempo obj WHERE project_project_id = :project_Id ")
	public List<Tempo> findTempos(@Param("project_Id") Integer id);
}


