package com.spiralmantra.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spiralmantra.consumer.entity.Laptop;
import com.spiralmantra.consumer.service.LaptopService;

@RestController
@RequestMapping("/consumer/")
public class LaptopController {

	@Autowired
	private LaptopService laptopService;

	@GetMapping("get")
	public Laptop getLaptop() {
		Laptop laptop = laptopService.getLaptopFromProducer();
		return laptop;
	}

	@GetMapping("update")
	public Laptop updateLaptop() {
		Laptop laptop = laptopService.updateLaptopFromProducer();
		return laptop;
	}

}
