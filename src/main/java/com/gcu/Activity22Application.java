package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ComponentScan({"com.gcu"})
@SpringBootApplication
public class Activity22Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Activity22Application.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("Test"));
	}

}
