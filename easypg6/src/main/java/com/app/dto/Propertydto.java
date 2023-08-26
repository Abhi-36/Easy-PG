package com.app.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

import com.app.pojos.Cities;
import com.app.pojos.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString 
public class Propertydto {
	
	private Long id;
	private String name;
	private String description;
	private String address;
	private Gender gender;
	private double rent;
	@Min(value = 1, message = "Minimum rating should be 1")
	@Max(value = 5, message = "Maximum rating should be 5")
	private	float ratingClean;
	@Min(value = 1, message = "Minimum rating should be 1")
	@Max(value = 5, message = "Maximum rating should be 5")
	private float ratingFood;
	@Min(value = 1, message = "Minimum rating should be 1")
	@Max(value = 5, message = "Maximum rating should be 5")
	private float ratingSafety;
	private Long city_id;
}
