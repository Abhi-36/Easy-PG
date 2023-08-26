package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.Reviewdto;
import com.app.pojos.Reviews;

public interface ReviewsServ {

	public List<Reviewdto> getAllReview();
	public ApiResponse addReview(Reviewdto review);
	public String deleteReview(Long id);
}
