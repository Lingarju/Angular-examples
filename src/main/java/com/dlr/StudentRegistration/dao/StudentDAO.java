package com.dlr.StudentRegistration.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlr.StudentRegistration.models.Student;
import com.dlr.StudentRegistration.repository.StudentRepository;

@Service
public class StudentDAO {
	
	@Autowired
	StudentRepository studentRepository;
	
	/* To save a Student */
	public Student save(Student std) {
		return studentRepository.save(std);
	}
	
	/* search all students */
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	/* get a student by id */
	public Student findOne(Long stdId) {
		return studentRepository.findOne(stdId);
	}
	 
	/* delete a student */
	public void delete(Student std) {
		studentRepository.delete(std);
	}
}
