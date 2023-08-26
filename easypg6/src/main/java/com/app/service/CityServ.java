package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.Citiesdto;
import com.app.pojos.Cities;

public interface CityServ {

	public List<Citiesdto> getAllCities();
	
	public Citiesdto getById(Long id);
	public ApiResponse addCity(Citiesdto city);
	
	public String deleteCities(Long id);
	public Cities updateCity(Citiesdto ct);
}
