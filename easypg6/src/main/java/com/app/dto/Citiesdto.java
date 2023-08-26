package com.app.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Citiesdto {
	
	private Long id;
	@NotBlank
	private String name;
	
}
