package com.antonromanov.firstcrud.firstcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class FirstcrudApplication extends SpringBootServletInitializer {



	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FirstcrudApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FirstcrudApplication.class, args);
	}


}
