package com.fiskra.sample.vaadin.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiskra.sample.vaadin.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	List<Student> findByLastNameStartsWithIgnoreCase(String lastName);
	
	List<Student> findByFirstNameStartsWithIgnoreCase(String firstName);

}
