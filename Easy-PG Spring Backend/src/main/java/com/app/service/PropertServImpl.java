package com.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CityDao;
import com.app.dao.FacilitiesDao;
import com.app.dao.PropertDao;
import com.app.dto.ApiResponse;
import com.app.dto.Citiesdto;
import com.app.dto.Converterdto;
import com.app.dto.Facilitiesdto;
import com.app.dto.Facilitiesdto2;
import com.app.dto.PropertyFacilitydto;
import com.app.dto.Propertydto;
import com.app.exception_handler.GlobalExceptionHandler;
import com.app.pojos.Cities;
import com.app.pojos.Facilities;
import com.app.pojos.Properties;
import com.app.pojos.User;

@Service
@Transactional
public class PropertServImpl implements PropertServ {

	@Autowired
	private PropertDao propertyDao;

	@Autowired
	private CityDao citiesDao;

	@Autowired
	public ModelMapper mapper;

	@Autowired
	private FacilitiesDao facilitiesDao;

	public List<Propertydto> maptoDto(List<Properties> list) {
		List<Propertydto> propertyDtoList = new ArrayList<Propertydto>();

		for (Properties e : list) {
			Propertydto d = new Propertydto();
			d.setId(e.getId());
			d.setAddress(e.getAddress());
			d.setDescription(e.getDescription());
			d.setName(e.getName());
			d.setGender(e.getGender());
			d.setRatingClean(e.getRatingClean());
			d.setRatingFood(e.getRatingFood());
			d.setRatingSafety(e.getRatingSafety());
			d.setRent(e.getRent());
			d.setCity_id(e.getMyCity().getId());

			propertyDtoList.add(d);                 
		}

		return propertyDtoList;
	}
	Converterdto converter = new Converterdto();

	@Override
	public List<Propertydto> getPropertiesByCityName(String cityName) {
		Cities city = citiesDao.findByName(cityName);
		return maptoDto(city.getProperties());
	}

	@Override
	public ApiResponse addProperty(Propertydto property) {

		Converterdto converter = new Converterdto();
		Properties propt = converter.toPropertyEntity(property);
		Properties prop = propertyDao.save(propt);

		return new ApiResponse("Property Added Successfully");
	}

	@Override
	public Properties updateProperty(Propertydto pt) {
		Properties prot = propertyDao.findById(pt.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid city ID !!!!!"));
		
		Properties propt = converter.toProperty(pt);
		return propertyDao.save(propt);
	}

	@Override
	public List<Propertydto> getAllProperties() {

		List<Propertydto>propertyDtoList = new ArrayList<Propertydto>();
		List<Properties> prop = propertyDao.findAll();
		System.out.println(prop.get(0).getMyCity().getId());
		
	//	List<Propertydto> propertyDtoList=maptoDto(prop);
		
		propertyDtoList = Arrays.asList(mapper.map(prop,Propertydto[].class));
		
//		for (Properties e : prop) {
//			Propertydto d = new Propertydto();
//			d.setId(e.getId());
//			d.setAddress(e.getAddress());
//			d.setDescription(e.getDescription());
//			d.setName(e.getName());
//			d.setGender(e.getGender());
//			d.setRatingClean(e.getRatingClean());
//			d.setRatingFood(e.getRatingFood());
//			d.setRatingSafety(e.getRatingSafety());
//			d.setRent(e.getRent());
//			d.setCity_id(e.getMyCity().getId());
//
//			propertyDtoList.add(d);                 
//		}
		return propertyDtoList;
	}

//	@Override
//	public List<Facilitiesdto> findById(Long propId) {
//		
//		Properties prop = propertyDao.findById(propId).orElseThrow();
//		System.out.println(prop);
//		List<Facilities> list = prop.getFacilities();
//
//		List<Facilitiesdto> facilityDtoList = new ArrayList<Facilitiesdto>();
//		for (Facilities e : list) {
//			Facilitiesdto fd = new Facilitiesdto();
//			fd.setId(e.getId());
//			fd.setName(e.getName());
//			fd.setType(e.getType());
//			facilityDtoList.add(fd);
//		}
////		System.out.println(list.get(0).getName());
//		prop.getFacilities().size();// avoid lazy init
//		return facilityDtoList;
//	}

	public String addPropertiesAndFacilities(PropertyFacilitydto prorFac) {

		Properties entity = new Properties();
		List<Facilitiesdto2> list = prorFac.getFacilities();

		entity.setId(prorFac.getId());
		entity.setAddress(prorFac.getAddress());
		entity.setDescription(prorFac.getDescription());
		entity.setName(prorFac.getName());
		entity.setGender(prorFac.getGender());
		entity.setRatingClean(prorFac.getRatingClean());
		entity.setRatingFood(prorFac.getRatingFood());
		entity.setRatingSafety(prorFac.getRatingSafety());
		entity.setRent(prorFac.getRent());
		Cities ct=citiesDao.findByName(prorFac.getCityName().getName());
		entity.setMyCity(ct);
		
		List<Facilities> l = new ArrayList<Facilities>();
		for (Facilitiesdto2 facilities : list) {
			Facilities f = new Facilities();
			f.setName(facilities.getName());
			f.setType(facilities.getType());
			f.addProperties(entity);
			facilitiesDao.save(f);
		}
		entity.addFacilities(l);
		propertyDao.save(entity);
		return "added";
	}

	@Override
	public String deleteProperties(Long id) {
		
		Properties p=propertyDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid User ID !!!!!"));
		propertyDao.delete(p);
		return "prperty deleted";
	}

	@Override
	public Propertydto getById(Long id) {
		Properties prop = propertyDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Property ID !!!!!"));
		
		return mapper.map(prop, Propertydto.class);
		
	}

	
	
	
}
