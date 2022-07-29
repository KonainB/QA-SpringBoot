package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public String city() {
		return "New York";
	}
	@Bean
	public String flower() {
		return "Rose";
	}

}
