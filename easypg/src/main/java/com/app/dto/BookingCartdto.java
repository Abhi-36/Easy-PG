package com.app.dto;

import java.util.List;

import com.app.pojos.CartProperties;
import com.app.pojos.Properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookingCartdto {

	private List<CartProperitesdto>properties;
}
