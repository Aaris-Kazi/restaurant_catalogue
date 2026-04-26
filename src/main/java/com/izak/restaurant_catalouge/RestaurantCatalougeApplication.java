package com.izak.restaurant_catalouge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestaurantCatalougeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantCatalougeApplication.class, args);
	}

	@Bean
	// @LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
