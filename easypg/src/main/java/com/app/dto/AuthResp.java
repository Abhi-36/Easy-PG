package com.app.dto;


import com.app.pojos.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthResp {
		
		private Long id;
		private String email;
		private String fullName;
		private long mobNo;

		private Gender gender;

		private String role;

	}

