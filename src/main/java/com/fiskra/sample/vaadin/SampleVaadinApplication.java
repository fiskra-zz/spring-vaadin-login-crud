package com.fiskra.sample.vaadin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleVaadinApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SampleVaadinApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SampleVaadinApplication.class, args);
	}
}
