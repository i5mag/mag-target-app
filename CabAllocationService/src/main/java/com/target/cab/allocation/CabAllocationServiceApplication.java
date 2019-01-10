package com.target.cab.allocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.target.cab.allocation.controller", "com..target.cab.allocation.service"})
@EntityScan(basePackages = {"com.target.cab.allocation.dataaccess"})
@EnableJpaRepositories(basePackages = {"com.target.cab.allocation.dataaccess"})
public class CabAllocationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabAllocationServiceApplication.class, args);
	}
}
