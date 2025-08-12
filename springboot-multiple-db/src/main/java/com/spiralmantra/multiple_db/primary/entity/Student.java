package com.spiralmantra.multiple_db.primary.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student_table")
public class Student {

	@Id
	private int id;
	private String name;
	private String school;
	private double schoolFee;
	
	public Student() {

	}

	public Student(String name, String school, double schoolFee) {
		this.name = name;
		this.school = school;
		this.schoolFee = schoolFee;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public double getSchoolFee() {
		return schoolFee;
	}

	public void setSchoolFee(double schoolFee) {
		this.schoolFee = schoolFee;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", school=" + school + ", schoolFee=" + schoolFee + "]";
	}
	
}
