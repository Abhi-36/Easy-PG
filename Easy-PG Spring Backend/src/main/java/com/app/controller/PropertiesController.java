package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dto.Citiesdto;
import com.app.dto.Facilitiesdto;
import com.app.dto.PropertyFacilitydto;
import com.app.dto.Propertydto;
import com.app.pojos.Cities;
import com.app.pojos.Facilities;
import com.app.pojos.Properties;
import com.app.service.PropertServ;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@RestController
@RequestMapping("/properties")
@JsonIgnoreType
@CrossOrigin(origins = "http://localhost:3000")
public class PropertiesController {

	@Autowired
	public PropertServ propertyServ;
	
	public PropertiesController() {
		System.out.println("propertiesControllerCalled");
	}
	
	@GetMapping("/list/{cityName}")
    public List<Propertydto> getPropertiesByCityName(@PathVariable String cityName) {
        return propertyServ.getPropertiesByCityName(cityName);
    }
	
	@GetMapping
	public List<Propertydto> listAllProperties(){
		System.out.println("in listProperties");
		return propertyServ.getAllProperties();
	}
	
//	@GetMapping("/{id}")
//    public List<Facilitiesdto> getPropertiesById(@PathVariable Long id) {
//        return propertyServ.findById(id);
//    }
	
	@GetMapping("Byid/{id}")
	public Propertydto getById(@PathVariable Long id){
		
		return propertyServ.getById(id);
	}
	
	
	
	
	
	

}
