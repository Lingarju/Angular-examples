package com.dlr.StudentRegistration.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlr.StudentRegistration.dao.StudentDAO;
import com.dlr.StudentRegistration.models.Student;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	StudentDAO studentDAO;
	
	/* to save a Student */
	@PostMapping("/student")
	public Student registerStudent(@Valid @RequestBody Student std) {
		return studentDAO.save(std);
	}
	
	/* get all students */
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentDAO.findAll();
	}
	
	/* get student by id */
	@GetMapping("/notes/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value="id") Long stdId) {
		Student std = studentDAO.findOne(stdId);
		
		if(std == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(std);
	}
	
	/* update a student by stdId */
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value="id") Long stdId,@Valid @RequestBody Student stdDetails) {
		
		Student std = studentDAO.findOne(stdId);
		if(std == null) {
			return ResponseEntity.notFound().build();
		}
		std.setFirstName(stdDetails.getFirstName());
		std.setLastName(stdDetails.getLastName());
		std.setAddress(stdDetails.getAddress());
		
		Student updateStudent = studentDAO.save(std);
		return ResponseEntity.ok().body(updateStudent);
	}
	
	/* delete a student */
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable(value="id") Long stdId) {
		Student std = studentDAO.findOne(stdId);
		if(std == null) {
			return ResponseEntity.notFound().build();
		}
		studentDAO.delete(std);
		
		return ResponseEntity.ok().build();
	}
}
