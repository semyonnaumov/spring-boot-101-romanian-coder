package com.naumov.booking;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJSONDoc // Enable documentation
public class SpringTestRomanianApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTestRomanianApplication.class, args);
	}

}
