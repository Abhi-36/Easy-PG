package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Citiesdto;
import com.app.dto.Facilitiesdto;
import com.app.pojos.Cities;
import com.app.pojos.Facilities;
import com.app.service.FacilitiesServ;

@RestController
@RequestMapping("/facilities")
@CrossOrigin(origins = "http://localhost:3000")
public class FacilitiesController {

	@Autowired
	private FacilitiesServ facilitiesServ;
	
	@GetMapping("/{id}")
	public Facilitiesdto getById(@PathVariable Long id) {
		return facilitiesServ.getById(id);
	}
	
	@GetMapping
	public List<Facilitiesdto> listAllFacilities(){
		System.out.println("in listCities");
		return facilitiesServ.getAllFacilites();
	}
}
