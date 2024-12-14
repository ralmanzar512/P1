package com.cpcd.microservices.app.estudiantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicioestudiantesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioestudiantesApplication.class, args);
	}

}

