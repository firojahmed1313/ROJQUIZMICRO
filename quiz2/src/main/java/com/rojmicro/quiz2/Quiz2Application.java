package com.rojmicro.quiz2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Quiz2Application {

	public static void main(String[] args) {
		SpringApplication.run(Quiz2Application.class, args);
	}

}
