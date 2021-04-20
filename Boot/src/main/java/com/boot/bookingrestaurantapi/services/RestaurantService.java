package com.boot.bookingrestaurantapi.services;

import java.util.List;

import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.CreateRestaurant;
import com.boot.bookingrestaurantapi.jsons.RestaurantRest;

public interface RestaurantService {

	RestaurantRest getRestaurantById(Long restaurantID)throws BookingException;
	public List<RestaurantRest> getRestaurants() throws BookingException;
	RestaurantRest createRestaurant(CreateRestaurant createRestaurant) throws BookingException;
}
