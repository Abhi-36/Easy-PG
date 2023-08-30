package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.AdminDao;
import com.app.dto.AdminAuthResp;
import com.app.dto.AdminDto;
import com.app.dto.AuthRequest;
import com.app.dto.Converterdto;
import com.app.pojos.Admin;

@Service
@Transactional
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminDao admindao;
	
	@Autowired
	public ModelMapper mapper;

	@Override
	public Admin addAdmin(AdminDto admin) 
	{
		Converterdto dto = new Converterdto();
		Admin a = dto.toAdmin(admin);
		Admin a1= admindao.save(a);
		return a1;
	}

	@Override
	public AdminAuthResp signinAdmin(AuthRequest req) {
		Admin admin=admindao.findByEmailAndPassword(req.getEmail(), req.getPassword())
		 .orElseThrow(() -> new ResourceNotFoundException("invalid email or Password....!"));
       
		return mapper.map(admin, AdminAuthResp.class);
	}
	



	


	

}
