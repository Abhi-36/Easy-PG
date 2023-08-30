package com.app.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import com.app.pojos.Gender;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class UserDto {
	
	
	private Long id;
	@Email
	private String email;
	
	private String password;

	private String fullName;
	private long mobNo;
	private String address;
	private Gender gender;

	private String role;

}
