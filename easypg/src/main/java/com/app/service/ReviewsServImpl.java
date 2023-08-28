package com.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.PropertDao;
import com.app.dao.ReviewDao;
import com.app.dao.UserDao;
import com.app.dto.ApiResponse;
import com.app.dto.Reviewdto;
import com.app.pojos.Properties;
import com.app.pojos.Reviews;
import com.app.pojos.User;

@Service
@Transactional
public class ReviewsServImpl implements ReviewsServ {
	@Autowired
	public ReviewDao reviewDao;

	@Autowired
	public ModelMapper mapper;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PropertDao properDao;

	@Override
	public List<Reviewdto> getAllReview() {

		final List<Reviewdto> ReviewsDtoList = new ArrayList<Reviewdto>();
		List<Reviews> reviews = reviewDao.findAll();
		reviews
		.forEach((e)->
		{
			Reviewdto r=mapper.map(e, Reviewdto.class);
			r.setPropertyid(e.getProperty().getId());
			r.setUserid(e.getUser().getId());
			ReviewsDtoList.add(r);});
//		ReviewsDtoList = Arrays.asList();
		
		return ReviewsDtoList;
	}

	@Override
	public ApiResponse addReview(Reviewdto review) {
		
		Properties property = properDao.findById(review.getPropertyid()).orElseThrow(()->new RuntimeException("Property Not found"));
		System.out.println(property.getName());
		User user = userDao.findById(review.getUserid()).orElseThrow(()->new RuntimeException("user Not found"));
		
		Reviews rev = new Reviews(review.getContent(), property, user);
		
		reviewDao.save(rev);

		return new ApiResponse("Review Added Successfully");
	}

	@Override
	public String deleteReview(Long id) {

		Reviews rev= reviewDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid User ID !!!!!"));
		
		return null;
	}

}
