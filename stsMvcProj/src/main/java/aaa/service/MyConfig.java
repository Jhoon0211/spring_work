package aaa.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import aaa.model.Battery;

@Configuration
@Component
public class MyConfig {
	
	@Bean
	Battery bat1() {
		return new Battery("로케트밧데리", 500);
	}
	
	@Bean
	Battery bat2() {
		return new Battery("사랑의밧데리", 300);
	}
	
}
