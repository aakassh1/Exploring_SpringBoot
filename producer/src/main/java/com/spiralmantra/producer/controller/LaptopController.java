package com.spiralmantra.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spiralmantra.producer.entity.Laptop;

@RestController
@RequestMapping("/producer/")
public class LaptopController {

	@GetMapping("getLaptop")
	public Laptop createLaptop() {
		return new Laptop(121,"Dell","Silver",24999.9);
	}
	
}
