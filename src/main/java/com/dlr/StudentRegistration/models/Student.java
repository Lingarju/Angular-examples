package com.dlr.StudentRegistration.models;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="student")
@EntityListeners(AuditingEntityListener.class)
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String student_id;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private String gender;

	@NotBlank
	private String address;
	
	@NotBlank
	private String email;
	
	public Student(Student std) {
		this.student_id = std.getStudent_id();
		this.firstName = std.getFirstName();
		this.lastName = std.getLastName();
		this.gender = std.getGender();
		this.address = std.getAddress();
		this.email = std.getEmail();
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
