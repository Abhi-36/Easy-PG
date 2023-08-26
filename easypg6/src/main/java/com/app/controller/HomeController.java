package com.app.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.pojos.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/User")

public class HomeController {
	
	@Autowired
	public UserService userservice;
	
	@Autowired
	public ModelMapper mapper;
	
	@PostMapping("/Signup")
	public User Signup(@RequestBody @Valid UserDto userdto)
	{
		User puser = userservice.addUser(userdto);	
		return  puser;		
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> signInEmployee(@RequestBody @Valid AuthRequest request) {
		System.out.println("auth req " + request);
	
			AuthResp resp = userservice.Signin(request);
			return ResponseEntity.ok(resp);

	} 

}
