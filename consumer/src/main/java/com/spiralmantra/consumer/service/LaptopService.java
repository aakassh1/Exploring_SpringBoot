package com.spiralmantra.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spiralmantra.consumer.entity.Laptop;

@Service
public class LaptopService {

	@Autowired
	private RestTemplate restTemplate;
	
	public Laptop getLaptopFromProducer() {
		String url = "http://localhost:8081/producer/getLaptop";
		Laptop laptop = restTemplate.getForObject(url, Laptop.class);
		return laptop;
	}
	
	public Laptop updateLaptopFromProducer() {
		Laptop laptop = getLaptopFromProducer();
		laptop.setName("Asus");
		laptop.setPrice(39999.23);
		return laptop;
	}
	
}
