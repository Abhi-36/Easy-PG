package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.dto.Propertydto;
import com.app.dto.UserDto;
import com.app.pojos.User;



public interface UserService {
	
public List<UserDto> getAllusers();
	
	public UserDto getById(Long id);
	public User getUserSById(Long id);
	public User addUser(UserDto user);
	
	public String deleteUser(Long id);
	
	public User updateUser(UserDto dto);
	public AuthResp Signin(AuthRequest req);
	
	public List<Propertydto> findById(Long id);
	
	public String addToBook(Long userId,Long propertyId);
}
