package com.spiralmantra.multiple_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spiralmantra.multiple_db.primary.entity.Student;
import com.spiralmantra.multiple_db.secondry.entity.Employee;
import com.spiralmantra.multiple_db.service.MyService;

@RestController
public class MyController {

	@Autowired
	private MyService service;
	
	@PostMapping("student/save")
	public Student saveStudent(@RequestBody Student student) {
		Student saveStudent = service.saveStudent(student);
		return saveStudent;
	}
	
	@PostMapping("employee/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		Employee saveEmployee = service.saveEmployee(employee);
		return saveEmployee;
	}
	
	@GetMapping("student/get")
	public List<Student> getAllStudent(){
		return service.getAllStudent();
	}
	
	@GetMapping("employee/get")
	public List<Employee> getAllEmployee(){
		return service.getAllEmployee();
	}
	
	@GetMapping("student/get/{id}")
	public Student getStudentById(@PathVariable int id) {
		return service.getStudentbyId(id);
	}
	
	@GetMapping("employee/get/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return service.getEmployeeById(id);
	}
	
	@PutMapping("student/update")
	public String updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}
	
	@PutMapping("employee/update")
	public String updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}
	
	@DeleteMapping("student/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
	}
	
	@DeleteMapping("employee/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}
	
}
