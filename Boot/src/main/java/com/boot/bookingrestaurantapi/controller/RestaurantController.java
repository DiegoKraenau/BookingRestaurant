package com.boot.bookingrestaurantapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.services.RestaurantService;
import com.boot.bookingrestaurantapi.jsons.*;
import com.boot.bookingrestaurantapi.responses.BookingResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/booking-restaurant"+"/v1")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/restaurant/{restaurantId}")
	public BookingResponse<RestaurantRest> getRestaurantById(@PathVariable Long restaurantId) throws BookingException{
		return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
				restaurantService.getRestaurantById(restaurantId));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/restaurants")
	public BookingResponse<List<RestaurantRest>> getRestaurants() throws BookingException{
		return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",restaurantService.getRestaurants());
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/restaurants")
	public BookingResponse<RestaurantRest> createRestaurant(@RequestBody @Validated CreateRestaurant createRestaurant) throws BookingException{
		return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",restaurantService.createRestaurant(createRestaurant));
	}
}
