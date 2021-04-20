package com.boot.bookingrestaurantapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.bookingrestaurantapi.entities.Restaurant;
import com.boot.bookingrestaurantapi.jsons.CreateRestaurant;
import com.boot.bookingrestaurantapi.jsons.RestaurantRest;
import com.boot.bookingrestaurantapi.repositories.RestaurantRepository;
import com.boot.bookingrestaurantapi.services.RestaurantService;
import com.boot.bookingrestaurantapi.exceptions.*;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	public static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public RestaurantRest getRestaurantById(Long restaurantID) throws BookingException {
		// TODO Auto-generated method stub
		return modelMapper.map(getRestaurantEntity(restaurantID), RestaurantRest.class);
	}

	@Override
	public List<RestaurantRest> getRestaurants() throws BookingException {
		// TODO Auto-generated method stub
		final List<Restaurant> restauratsEntity = restaurantRepository.findAll();
		
		return restauratsEntity.stream().map(service->modelMapper.map(service, RestaurantRest.class))
								.collect(Collectors.toList());
	}

	@Override
	public RestaurantRest createRestaurant(CreateRestaurant createRestaurant) throws BookingException {
		// TODO Auto-generated method stub
		Restaurant restaurantEntity;
		Restaurant restaurant = new Restaurant();
		restaurant.setName(createRestaurant.getName());
		restaurant.setAddress(createRestaurant.getAddress());
		restaurant.setDescription(createRestaurant.getDescription());
		restaurant.setImage(createRestaurant.getImage());
		
		try {
			restaurantEntity = restaurantRepository.save(restaurant);
		} catch (Exception e) {
			// TODO: handle exception
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return modelMapper.map(getRestaurantEntity(restaurantEntity.getId()), RestaurantRest.class);
	}
	
	private Restaurant getRestaurantEntity(Long restaurantID) throws BookingException{
		return restaurantRepository.findById(restaurantID)
									.orElseThrow(()->new NotFountException("SNOT-4040-1","RESTAURANT_NOT_FOUND"));
	}

}
