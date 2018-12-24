package com.dlr.StudentRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlr.StudentRegistration.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findOne(Long stdId);
	Student save(Student std);
	List findAll();
	void delete(Student std);

}
 