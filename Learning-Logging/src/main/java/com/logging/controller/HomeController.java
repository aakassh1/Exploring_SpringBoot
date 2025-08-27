package com.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping
	public String homePage(@RequestParam(defaultValue = "default value", required = false) String value) {
		System.out.println("Home controller is running...");
		logger.info("Home api is calling {}", value);
		logger.debug("Debugging the home api {}", value);
		logger.trace("Something minute is being wrong {}", value);
		logger.warn("Something is going to be wrong in this home api calling {}", value);
		logger.error("Home api is crashed {}", value);
		return "Welcome Home";
	}
	
}
