package com.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.FacilitiesDao;
import com.app.dto.ApiResponse;
import com.app.dto.Converterdto;
import com.app.dto.Facilitiesdto;
import com.app.pojos.Facilities;

@Service
@Transactional
public class FacilitiesServImpl implements FacilitiesServ {

	@Autowired
	public FacilitiesDao facilitiesDao;

	@Autowired
	public ModelMapper mapper;

	@Override
	public ApiResponse addFacilities(Facilitiesdto facilities) {

		Converterdto dto = new Converterdto();
		Facilities ctyo = dto.toFacilities(facilities);
		Facilities fty = facilitiesDao.save(ctyo);
		return new ApiResponse("Facility Added Successfully");
	}

	@Override
	public Facilitiesdto getById(Long id) {
		Facilities facilities = facilitiesDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid city ID !!!!!"));
		return mapper.map(facilities, Facilitiesdto.class);
	}

	@Override
	public Facilitiesdto updateFacilities(Facilitiesdto facilities) {

		Facilities fc = facilitiesDao.findById(facilities.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid city ID !!!!!"));
		Converterdto dto = new Converterdto();
		Facilities ctyo = dto.toFacilities(facilities);
		Facilities prop=facilitiesDao.save(ctyo);
		
		return mapper.map(prop, Facilitiesdto.class);
	}

	@Override
	public String deleteFacility(Long id) {
		Facilities fc = facilitiesDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Facility ID !!!!!"));
		facilitiesDao.delete(fc);
		return "Facility Deleted";
	}

	@Override
	public List<Facilitiesdto> getAllFacilites() {

		List<Facilitiesdto> facilitiesDtoList = new ArrayList<Facilitiesdto>();
		List<Facilities> facilities = facilitiesDao.findAll();
		facilitiesDtoList = Arrays.asList(mapper.map(facilities, Facilitiesdto[].class));
		return facilitiesDtoList;
	}

}
