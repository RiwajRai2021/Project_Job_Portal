package com.project.jobportal.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.jobportal.entity.UsersType;
import com.project.jobportal.respository.UsersTypeRepository;

@Service
public class UsersTypeService {
	
	private final UsersTypeRepository usersTypeRepository;

	public UsersTypeService(UsersTypeRepository usersTypeRepository) {
		super();
		this.usersTypeRepository = usersTypeRepository;
	} 
	
	public List<UsersType>getAll(){
		return usersTypeRepository.findAll();
	}

}
