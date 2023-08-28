package com.app.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 import org.springframework.beans.factory.annotation.Autowired;

import com.app.dto.AdminAuthResp;
import com.app.dto.AdminDto;
import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.dto.UserDto;
import com.app.pojos.Admin;
import com.app.pojos.User;
import com.app.service.AdminService;
import com.app.service.UserService;

@RestController
@RequestMapping("/HomePage")

public class HomeController {
	
	@Autowired
	public UserService userservice;
	
	@Autowired
	public AdminService adminservice;
	
	@Autowired
	public ModelMapper mapper;
	
	@PostMapping("/SignupUser")
	public User Signup(@RequestBody @Valid UserDto userdto)
	{
		User puser = userservice.addUser(userdto);	
		return  puser;		
	}
	
	@PostMapping("/signinUser")
	public ResponseEntity<?> signInUser(@RequestBody @Valid AuthRequest request) {
		System.out.println("auth req " + request);
	
			AuthResp resp = userservice.Signin(request);
			return ResponseEntity.ok(resp);

	} 
	@PostMapping("/SignupAdmin")
	public Admin SignupAdmin(@RequestBody @Valid AdminDto admindto)
	{
		Admin padmin = adminservice.addAdmin(admindto);	
		return  padmin;		
	}
	
	@PostMapping("/signinAdmin")
	public ResponseEntity<?> signInAdmin(@RequestBody @Valid AuthRequest request) {
		System.out.println("auth req " + request);
	
			AdminAuthResp resp = adminservice.signinAdmin(request);
			return ResponseEntity.ok(resp);
	}


}
