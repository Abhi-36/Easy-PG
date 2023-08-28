package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.Citiesdto;
import com.app.dto.Facilitiesdto;
import com.app.pojos.Facilities;

public interface FacilitiesServ {

	ApiResponse addFacilities(Facilitiesdto facilities);
	
	public Facilitiesdto updateFacilities(Facilitiesdto  facilities);
	
	public Facilitiesdto getById(Long id);
	public String deleteFacility(Long id);

	public List<Facilitiesdto> getAllFacilites();
}
