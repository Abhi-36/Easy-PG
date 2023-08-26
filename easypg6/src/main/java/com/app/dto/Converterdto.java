package com.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.app.pojos.Cities;
import com.app.pojos.Facilities;
import com.app.pojos.Properties;
import com.app.pojos.Reviews;
import com.app.pojos.User;

public class Converterdto {

	public Cities toCities(Citiesdto dto) {
		Cities entity = new Cities();
		entity.setName(dto.getName());
		entity.setId(dto.getId());
		return entity;
	}
	
	public Properties toProperty(Propertydto dto) {
		
		Properties entity=new Properties();
		
		entity.setId(dto.getId());
		entity.setAddress(dto.getAddress());
		entity.setDescription(dto.getDescription());
		entity.setName(dto.getName());
		entity.setGender(dto.getGender());
		entity.setRatingClean(dto.getRatingClean());
		entity.setRatingFood(dto.getRatingFood());
		entity.setRatingSafety(dto.getRatingSafety());
		entity.setRent(dto.getRent());
		entity.setMyCity(new Cities(dto.getCity_id()));
		return entity;
	}

	public Facilities toFacilities(Facilitiesdto dto) {
		Facilities entity=new Facilities();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setType(dto.getType());
		return entity;
	}
	
	public User toUser(UserDto dto)
	{
		User entity = new User();
		entity.setId(dto.getId());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setFullName(dto.getFullName());
		entity.setRole(dto.getRole());
		entity.setAddress(dto.getAddress());
		entity.setMobNo(dto.getMobNo());
		entity.setGender(dto.getGender());
		
		return entity;
		
	}
	public Properties toPropertyEntity(Propertydto dto) {
		
		Properties entity=new Properties();
		
		entity.setId(dto.getId());
		entity.setAddress(dto.getAddress());
		entity.setDescription(dto.getDescription());
		entity.setName(dto.getName());
		entity.setGender(dto.getGender());
		entity.setRatingClean(dto.getRatingClean());
		entity.setRatingFood(dto.getRatingFood());
		entity.setRatingSafety(dto.getRatingSafety());
		entity.setRent(dto.getRent());
		entity.setMyCity(new Cities(dto.getCity_id()));
		return entity;
	}
	public Propertydto toPropertydto(Properties prop) {
		
		Propertydto dto=new Propertydto();
		
		dto.setAddress(prop.getAddress());
		dto.setId(prop.getId());
		dto.setDescription(prop.getDescription());
		dto.setGender(prop.getGender());
		dto.setName(prop.getName());
		dto.setRatingClean(prop.getRatingClean());
		dto.setRatingFood(prop.getRatingFood());
		dto.setRatingSafety(prop.getRatingSafety());
		dto.setRent(prop.getRent());
		dto.setCity_id(prop.getMyCity().getId());
		return dto;
	}
	
	
	
}

