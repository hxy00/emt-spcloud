package com.emt.euraka.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class EmtEurakaServerApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(EmtEurakaServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmtEurakaServerApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		logger.debug("!!!The server is started!!!");
	}
}
