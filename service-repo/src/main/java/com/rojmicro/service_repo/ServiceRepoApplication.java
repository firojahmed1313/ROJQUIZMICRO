package com.rojmicro.service_repo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRepoApplication.class, args);
	}

}
