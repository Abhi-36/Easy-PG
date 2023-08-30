package com.app.service;

import java.util.List;

import com.app.dto.BookingCartdto;
import com.app.pojos.BookingCart;

public interface BookingCartServ {

	String addPropertiesToCart(Long userId, Long prodId);
	BookingCartdto getCartDetails(Long userId);	
	String deleteCartContents(Long userId);
	
}
