package com.boot.bookingrestaurantapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="restaurants")
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique = true,nullable = false)
	private Long id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="address")
	private String address;
	
	@Column(name ="description")
	private String description;
	
	@Column(name ="image")
	private String image;

	
}
