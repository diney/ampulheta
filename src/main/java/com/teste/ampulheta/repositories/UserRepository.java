package com.teste.ampulheta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.ampulheta.domain.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
