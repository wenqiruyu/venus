package com.server.eureka.venus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class VenusEurekaServerApplication {

    private static final Logger logger = LoggerFactory.getLogger(VenusEurekaServerApplication.class);

    public static void main(String[] args) {

        logger.info("VenusEurekaServerApplication is start ...");
        SpringApplication.run(VenusEurekaServerApplication.class, args);
    }

}
