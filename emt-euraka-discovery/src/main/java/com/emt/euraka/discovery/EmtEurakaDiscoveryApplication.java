package com.emt.euraka.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmtEurakaDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmtEurakaDiscoveryApplication.class, args);
	}
}
