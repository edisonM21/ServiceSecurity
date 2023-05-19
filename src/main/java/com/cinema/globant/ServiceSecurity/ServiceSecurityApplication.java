package com.cinema.globant.ServiceSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableAutoConfiguration
@EnableConfigurationProperties
@SpringBootApplication
public class ServiceSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceSecurityApplication.class, args);
	}

}
