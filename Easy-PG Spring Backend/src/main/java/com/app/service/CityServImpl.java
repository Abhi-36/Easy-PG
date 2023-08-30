package com.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CityDao;
import com.app.dto.ApiResponse;
import com.app.dto.Citiesdto;
import com.app.dto.Converterdto;
import com.app.pojos.Cities;

@Service
@Transactional
public class CityServImpl implements CityServ {

	@Autowired
	public CityDao cityDao;
	
	@Autowired
	public ModelMapper mapper;
//	@Autowired
//	public Converterdto converter;
	
	@Override
	public List<Citiesdto> getAllCities() {

	        List<Citiesdto> citiesDtoList = new ArrayList<Citiesdto>();
	        List<Cities> cities = cityDao.findAll();
	        citiesDtoList = Arrays.asList(mapper.map(cities,Citiesdto[].class));
	        return citiesDtoList;  
	}
	
	@Override
	public String deleteCities(Long id) {

		Cities city = cityDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid city ID !!!!!"));
		cityDao.deleteById(id);
		return "city Deleted";
	}
	
	@Override
	public Citiesdto getById(Long id) {

		Cities city= cityDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid city ID !!!!!"));
		return mapper.map(city, Citiesdto.class);
	}

	@Override
	public ApiResponse addCity(Citiesdto city) {
		Converterdto dto=new Converterdto();
		 Cities ctyo  =dto.toCities(city);
		Cities cty= cityDao.save(ctyo);
		 return new ApiResponse("City Added");
	}

	@Override
	public Cities updateCity(Citiesdto city) {
		Cities ct=cityDao.findById(city.getId()).orElseThrow(() -> new ResourceNotFoundException("Invalid city ID !!!!!"));
		Converterdto dto=new Converterdto();
		 Cities ctyo  =dto.toCities(city);
		 
		return cityDao.save(ctyo);
	}

}
