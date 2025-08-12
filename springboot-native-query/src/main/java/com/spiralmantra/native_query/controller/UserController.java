package com.spiralmantra.native_query.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spiralmantra.native_query.entity.User;
import com.spiralmantra.native_query.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("save")
	public String saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("getAllUser")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@GetMapping("getById/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("getByEmail/{email}")
	public User getUserByEmail(@PathVariable String email) {
		User user = userService.getUserByEmail(email);
		return user;
	}
	
	@GetMapping("getByDob")
	public User getUserByDob(@RequestParam LocalDate dob) {
		return userService.getUserByDob(dob);
	}
	
	@GetMapping("bornAfter")
	public List<User> getUserBornAfter(@RequestParam LocalDate dob){
		return userService.getUserBornAfter(dob);
	}
	
	@GetMapping("getByNameAndEmail")
	public User getUserByNameAndEmail(@RequestParam String name, @RequestParam String email){
		return userService.getUserByNameAndEmail(name, email);
	}
	
	@GetMapping("getUserByName")
	public List<User> getUserByName(@RequestParam String name){
		return userService.getUserByName(name);
	}
	
	@GetMapping("countByAddress")
	public int countUserByCity(@RequestParam String address) {
		return userService.countUserByAddress(address);
	}
	
	@PatchMapping("updateAddressById")
	public String updateAddressById(@RequestParam int id,@RequestParam String address) {
		return userService.updateAddressbyId(id, address);
	}
	
}
