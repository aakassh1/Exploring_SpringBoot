package com.spiralmantra.native_query.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spiralmantra.native_query.entity.User;
import com.spiralmantra.native_query.repository.UserRepository;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;
	
	public String saveUser(User user) {
		User savedUser = userRepository.save(user);
		
		if(savedUser!=null) {
			return "User saved successfully";
		}
		
		return "User did not save";
	}
	
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	public User getUserById(int id) {
		Optional<User> data = userRepository.findById(id);
		
		if(data.isPresent()) {
			return data.get();
		}
		
		return null;
	}
	
	public User getUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	
	public User getUserByDob(LocalDate dob){
		return userRepository.findUserByDob(dob);
	}
	
	public List<User> getUserBornAfter(LocalDate dob){
		return userRepository.findUsersBornAfter(dob);
	}
	
	public User getUserByNameAndEmail(String name,String email){
		return userRepository.findUserByNameAndEmail(name, email);
	}
	
	public List<User> getUserByName(String name){
		return userRepository.findByName(name);
	}
	
	public int countUserByAddress(String address) {
		return userRepository.countUserByAddress(address);
	}
	
	public String updateAddressbyId(int id,String address) {
		User user = getUserById(id);
		
		if(user!=null) {
			user.setAddress(address);
			userRepository.save(user);
			return "User updated successfully";
		}
		
		return "User updation failed";
	}
}