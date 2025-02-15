package com.project.jobportal.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.jobportal.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	Optional<Users>findByEmail(String email); 
}
