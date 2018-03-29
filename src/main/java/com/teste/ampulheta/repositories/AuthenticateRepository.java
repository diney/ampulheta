package com.teste.ampulheta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.ampulheta.domain.Project;

public interface AuthenticateRepository extends JpaRepository<Project, Integer>  {

}
