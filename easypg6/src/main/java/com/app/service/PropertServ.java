package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.Facilitiesdto;
import com.app.dto.PropertyFacilitydto;
import com.app.dto.Propertydto;
import com.app.pojos.Facilities;
import com.app.pojos.Properties;

public interface PropertServ {

	public List<Propertydto> getPropertiesByCityName(String cityName);
	public 	ApiResponse addProperty(Propertydto property);
	public Properties updateProperty(Propertydto pt);
	public List<Propertydto> getAllProperties();
	public List<Facilitiesdto> findById(Long id);
	public String addPropertiesAndFacilities(PropertyFacilitydto prorFac);
	public String deleteProperties(Long id);
//	public String addFacilityToProperties();
	public Propertydto getById(Long id);
	
	
}
