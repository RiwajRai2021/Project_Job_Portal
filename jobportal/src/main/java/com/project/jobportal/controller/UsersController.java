package com.project.jobportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.jobportal.entity.Users;
import com.project.jobportal.entity.UsersType;
import com.project.jobportal.services.UserService;
import com.project.jobportal.services.UsersTypeService;

import jakarta.validation.Valid;

@Controller
public class UsersController {
	
	private final UsersTypeService usersTypeService;
	private final UserService userService; 
	

	@Autowired
	public UsersController(UsersTypeService usersTypeService, UserService userService) { //constructor injection 
		this.usersTypeService = usersTypeService;
		this.userService = userService;
	}
	
	@GetMapping("/register")
	public String register(Model model) { // method to show user registration form
		 List<UsersType>usersTypes= usersTypeService.getAll(); 
		 model.addAttribute("getAllTypes", usersTypes); 
		 model.addAttribute("user", new Users());
		 return "register"; 
	}
	
	@PostMapping("/register/new")
	public String userRegistration(@Valid Users users, Model model) {

		 Optional<Users>optionalUsers = userService.getUserByEmail(users.getEmail()); 
		 
		 if(optionalUsers.isPresent()) 
		 {
			 model.addAttribute("error", "Email already registered, try to login or register with other email."); 
			 List<UsersType>usersTypes= usersTypeService.getAll(); 
			 model.addAttribute("getAllTypes", usersTypes); 
			 model.addAttribute("user", new Users());
			 return "register"; 
		 }
		
		// System.out.println("User:: "+users);
		userService.addNew(users); 
		return "dashboard"; 
	}
	
	//update controller: 1. During registration, check if email exists before registering user
	//if email exists, add error message to model and return to registration form 
	
	

}
