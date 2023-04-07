package com.emonics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootMsWebClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMsWebClientApplication.class, args);
	}

}
