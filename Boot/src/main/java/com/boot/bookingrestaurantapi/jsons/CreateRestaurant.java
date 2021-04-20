package com.boot.bookingrestaurantapi.jsons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRestaurant {
	
	private String name;
	private String address;
	private String description;
	private String image;
}
