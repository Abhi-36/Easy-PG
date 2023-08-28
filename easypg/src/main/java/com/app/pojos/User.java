package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User extends BaseEntity {
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String fullName;
	@Column(length = 10, nullable = false)
	private long mobNo;
	@Column
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(length = 100)
	private String address;
	@Column
	private String role;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Reviews> reviews = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "interested_users_properties",
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "property_id"))
	private List<Properties> properties = new ArrayList<>();
	
	@OneToOne(mappedBy = "cartOwner",cascade = CascadeType.ALL,orphanRemoval = true)
	private BookingCart myCart;
	
	public User(Long id) {
		super();
		setId(id);
	}
	
	public void addCart(BookingCart cart)
	{
		//establish bi dir relationship
		setMyCart(cart);
		cart.setCartOwner(this);
	}
	
}
