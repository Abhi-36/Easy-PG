package com.app.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

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
@Component
public class PropertyFacilitydto {

	private Long id;
	private String name;
	private String description;
	private String address;
	private Gender gender;
	private double rent;
	private	float ratingClean;
	private float ratingFood;
	private float ratingSafety;
	private Citiesdto2 cityName;
	private List<Facilitiesdto2> facilities=new ArrayList<Facilitiesdto2>();
	
	
}
