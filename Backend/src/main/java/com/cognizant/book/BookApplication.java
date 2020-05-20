package com.cognizant.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class BookApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookApplication.class);

	public static void main(String[] args) {
		LOGGER.info("STARTED");
		SpringApplication.run(BookApplication.class, args);
	}
}
