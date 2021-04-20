package com.boot.bookingrestaurantapi.jsons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class RestaurantRest {
	
	private Long id;
	private String name;
	private String address;
	private String description;
	private String image;
}
