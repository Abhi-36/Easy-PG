package com.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.UserDao;
import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.dto.Converterdto;
import com.app.dto.Propertydto;
import com.app.dto.UserDto;
import com.app.pojos.Properties;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userdao;

	@Autowired
	public ModelMapper mapper;

	@Override
	public List<UserDto> getAllusers() {

		List<UserDto> UserDtoList = new ArrayList<UserDto>();
		List<User> users = userdao.findAll();
		UserDtoList = Arrays.asList(mapper.map(users, UserDto[].class));
		return UserDtoList;

	}

	@Override
	public UserDto getById(Long id) {

		User user = userdao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid User ID !!!!!"));
		return mapper.map(user, UserDto.class);
	}

	@Override
	public User addUser(UserDto user) {

		Converterdto dto = new Converterdto();
		User u = dto.toUser(user);
	User u1 = userdao.save(u);
		return u1;
	}

	@Override
	public String deleteUser(Long id) {

		User u = userdao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid User ID !!!!!"));
		userdao.delete(u);
		return "User Deleted";
	}

	@Override
	public User updateUser(UserDto udto) {
		User u = userdao.findById(udto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid city ID !!!!!"));
		Converterdto dto = new Converterdto();
		User u1 = dto.toUser(udto);
		return userdao.save(u1);

	}

	@Override
	public AuthResp Signin(AuthRequest req) {
		User user = userdao.findByEmailAndPassword(req.getEmail(), req.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("invalid email or Password....!"));
		System.out.println(user);
		return mapper.map(user, AuthResp.class);
	}

	public List<Propertydto> findById(Long userId) {
		User user=userdao.findById(userId).orElseThrow();
		List<Properties> list=user.getProperties();
		
		List<Propertydto> propertydtosList=new ArrayList<Propertydto>();
		
		for(Properties e:list) {
			
			Propertydto fd=new Propertydto();
			fd.setAddress(e.getAddress());
			fd.setDescription(e.getDescription());
			fd.setGender(e.getGender());
			fd.setName(e.getName());
			fd.setRatingClean(e.getRatingClean());
			fd.setRatingFood(e.getRatingFood());
			fd.setRatingSafety(e.getRatingSafety());
			fd.setRent(e.getRent());
			fd.setId(e.getId());
			propertydtosList.add(fd);
		}
		System.out.println(list.get(0).getAddress());
		user.getProperties().size();			
		return propertydtosList; 	
	}

	@Override
	public String addToBook(Long userId, Long propertyId) {
		
		
		return null;
	}

	@Override
	public User getUserSById(Long id) {

		User user=userdao.findById(id).orElseThrow();
		
		return user;
	}
}
