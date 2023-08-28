package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * ShoppingCart : id,int totalItems,totalCartPrice;
    
    private Customer cartOwner;

    
    private List<CartItem> cartItem=...
 */
@Entity
@Table(name ="BookingCarts")
@Getter
@Setter
@ToString(exclude = {"cartOwner","cartProperties"})
public class BookingCart extends BaseEntity {
	// Cart HAS-A Customer : uni dir asso between Cart 1----->1 Customer (owning side) : so LAZY should work ! I confirmed : using debugger : show User proxy
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id") // FK constraint
	private User cartOwner;

	// Cart HAS-A CartItems : bi dir asso between Cart 1---->* CartItem
	@OneToMany(mappedBy = "myCart", cascade = CascadeType.ALL, orphanRemoval = true/* ,fetch = FetchType.EAGER */)
	private List<CartProperties> cartProperties = new ArrayList<>();
	

	
}
