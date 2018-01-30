package com.vic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import redis.clients.jedis.Jedis;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(Application.class);
		application.run(args);
		
	}
	
}
