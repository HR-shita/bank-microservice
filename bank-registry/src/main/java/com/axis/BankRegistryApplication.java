package com.axis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BankRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankRegistryApplication.class, args);
	}

}
