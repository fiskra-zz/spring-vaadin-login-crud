package com.fiskra.sample.vaadin;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fiskra.sample.vaadin.model.Student;
import com.fiskra.sample.vaadin.model.User;
import com.fiskra.sample.vaadin.repo.StudentRepository;
import com.fiskra.sample.vaadin.repo.UserRepository;

@SpringBootApplication
public class SampleVaadinApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SampleVaadinApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SampleVaadinApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(StudentRepository repository, UserRepository userRepo) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Student("Jack", "Bauer", "+358 555 33 66", "Jack.Bauer@vaadin.com",new Date(System.currentTimeMillis())));
			repository.save(new Student("Chloe", "O'Brian", "+41 333 77 11", "Chloe.OBrian@vaadin.com",new Date(System.currentTimeMillis())));
			repository.save(new Student("Kim", "Bauer", "+88 478 12 47", "Kim.Bauer@vaadin.com", new Date(System.currentTimeMillis())));
			repository.save(new Student("David", "Palmer", "+90 364 58 43", "David.Palmer@vaadin.com", new Date(System.currentTimeMillis())));
			repository.save(new Student("Michelle", "Dessler", "+42 666 88 77", "Michelle.Dessler@vaadin.com", new Date(System.currentTimeMillis())));

			userRepo.save(new User("Feride","admin123"));
			userRepo.save(new User("admin","admin"));
			
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Student customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Student customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");
			User me = userRepo.findOne(1L);
			log.info("--------"+ "User: " + me.getId() + "---");
			User you = userRepo.findByUserNameAndPassword("admin", "admin");
			log.info("--------"+ "User 2: " + you.getId() + "---");
			// fetch customers by last name
			log.info("Customer found with findByLastNameStartsWithIgnoreCase('Bauer'):");
			log.info("--------------------------------------------");
			for (Student bauer : repository
					.findByLastNameStartsWithIgnoreCase("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}
	
}
