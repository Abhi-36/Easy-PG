package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Propertydto;
import com.app.dto.UserDto;
import com.app.pojos.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	public UserService userservice;
	
	public UserController() {
		System.out.println("UserControllerCalled");
	}
	
	@GetMapping("/{id}")
	public UserDto getById(@PathVariable Long id){
		System.out.println("in listUsers");
		return userservice.getById(id);
	}
	
	@PutMapping("/edit")
	public User updateUser(@RequestBody UserDto User)
	{
		return userservice.updateUser(User);		
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody UserDto User) {
	
		return ResponseEntity.ok(userservice.addUser(User));
	}
	
	@GetMapping("/showcart/{id}")
	public List<Propertydto> getPrpertiesById(@PathVariable Long id){
		return userservice.findById(id);
	}
	

}

