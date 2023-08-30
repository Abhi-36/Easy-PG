package com.app.dto;


import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Facilitiesdto2 {
	@NotBlank
	private String name;
	@NotBlank
	private String  type;

}
