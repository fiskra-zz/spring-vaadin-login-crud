package com.fiskra.sample.vaadin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fiskra.sample.vaadin.repo.StudentRepository;
import com.fiskra.sample.vaadin.repo.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleVaadinApplication.class)
public class SampleVaadinApplicationTests {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void shouldStudentsFillOutComponentsWithDataWhenAppStart(){
		assertEquals(5, this.studentRepository.count());
	}
	
	@Test
	public void shouldUsersFillOutComponentsWithDataWhenAppStart(){
		assertEquals(2, this.userRepository.count());
	}
	
	@Test
	public void shouldFindTwoBaurerStudents(){
		assertEquals(5, this.studentRepository.findByFirstNameStartsWithIgnoreCase("Baurer"));
	}
	
}
