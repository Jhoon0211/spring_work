package aaa.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import aaa.model.Battery;
import aaa.model.Season;

@Configuration
@Component
public class SeasonConfig {
	
	@Bean
	Season spring() {
		return new Season("spring", "sp1.jpg, sp2.jpg, sp3.jpg".split(","));
	}
	
	@Bean
	Season summer() {
		return new Season("summer", "sua.png, sub.png".split(","));
	}
	
	@Bean
	Season autumn() {
		return new Season("spring", "at_1.jpg, at_2.jpg, at_5.jpg, at_6.jpg".split(","));
	}
	
	@Bean
	Season winter() {
		return new Season("winter", "ww.jpg, ee.jpg, sp1.jpg".split(","));
	}
}
