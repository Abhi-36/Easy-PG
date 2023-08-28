package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.BookingCartdto;
import com.app.pojos.BookingCart;

public interface BookingCartDao extends JpaRepository<BookingCart, Long>{

	Optional<BookingCart> findByCartOwnerId(Long userId);
	@Query("select c from BookingCart c left outer join fetch c.cartProperties where c.cartOwner.id=?1")
	Optional<BookingCart> getCartWithCartItems(Long userId);

//	@Query (value="select * from carts",nativeQuery = true)
//	public List<BookingCartdto>getAllCart(userId);
}
