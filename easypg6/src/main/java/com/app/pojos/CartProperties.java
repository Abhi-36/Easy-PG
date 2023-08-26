package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "cart_Properties")
public class CartProperties extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private BookingCart myCart;
	@OneToOne
	@JoinColumn(name = "properties_id")
	private Properties properties;
}
