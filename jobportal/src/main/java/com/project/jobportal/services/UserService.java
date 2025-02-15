package com.project.jobportal.services;

import java.util.Date;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jobportal.entity.Users;
import com.project.jobportal.respository.UsersRepository;

@Service
public class UserService {

	private final UsersRepository usersRepository;

	@Autowired
	public UserService(UsersRepository usersRepository) {
		super();
		this.usersRepository = usersRepository;
	} 
	
	public Users addNew(Users users) {
		users.setActive(true);
		users.setRegistrationDate(new Date(System.currentTimeMillis()));
		return usersRepository.save(users); 
	}
	
	public Optional<Users>getUserByEmail(String email){
		
		return usersRepository.findByEmail(email); 
	}
	
}
