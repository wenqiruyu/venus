package com.server.eureka.venus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class VenusEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VenusEurekaServerApplication.class, args);
	}

}
