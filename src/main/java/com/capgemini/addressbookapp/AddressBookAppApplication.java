package com.capgemini.addressbookapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class AddressBookAppApplication {
	public static void main(String[] args) {
		log.info("Starting Address Book Application...");
		SpringApplication.run(AddressBookAppApplication.class, args);
		log.info("Address Book Application started successfully.");
	}
}

