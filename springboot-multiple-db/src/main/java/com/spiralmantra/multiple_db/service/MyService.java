package com.spiralmantra.multiple_db.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spiralmantra.multiple_db.primary.entity.Student;
import com.spiralmantra.multiple_db.primary.repository.StudentRepository;
import com.spiralmantra.multiple_db.secondary.repository.EmployeeRepository;
import com.spiralmantra.multiple_db.secondry.entity.Employee;

@Service
public class MyService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}
	
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}

	public Student getStudentbyId(int id) {

		Optional<Student> data = studentRepository.findById(id);
		
		if(data.isPresent()) {
			return data.get();
		} 
		
		return null;
	}
	
	public Employee getEmployeeById(int id) {
		Optional<Employee> data = employeeRepository.findById(id);
		
		if(data.isPresent()) {
			return data.get();
		}
		
		return null;
	}

	public String updateStudent(Student student) {

		Student availableStudent = getStudentbyId(student.getId());
		
		if(availableStudent!=null) {
			availableStudent.setName(student.getName());
			availableStudent.setSchool(student.getSchool());
			availableStudent.setSchoolFee(student.getSchoolFee());
			studentRepository.save(availableStudent);
			return "Student Updated Successfully";
		}
		
		return "Student not exits with this id";
	}

	public String updateEmployee(Employee employee) {
	
		Employee availableEmployee = getEmployeeById(employee.getId());
		
		if(availableEmployee!=null) {
			availableEmployee.setName(employee.getName());
			availableEmployee.setCompany(employee.getCompany());
			availableEmployee.setSalary(employee.getSalary());
			employeeRepository.save(availableEmployee);
			return "Employee updated successfully";
		}
		
		return "Employee does not exists with this id";
	}
	
	public String deleteStudent(int id) {
		Student student = getStudentbyId(id);
		
		if(student!=null) {
			studentRepository.deleteById(id);
			return "Student deleted successfully";
		}
		
		return "Student does not exists with this id";
	}

	public String deleteEmployee(int id) {
		Employee employee = getEmployeeById(id);
		
		if(employee!=null) {
			employeeRepository.deleteById(id);
			return "Employee deleted successfully";
		}
		
		return "Employee does not exists with this id";
	}
	
}
