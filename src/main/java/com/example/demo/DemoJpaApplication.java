package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
//@ComponentScan("com.example.*")
@ComponentScan({"com.example","com.example.service"})
@EntityScan("com.example.demo.entity")
@EnableJpaRepositories("com.example.demo.repository")
//@EnableSwagger2
public class DemoJpaApplication {


	public static void main(String[] args) {

		SpringApplication.run(DemoJpaApplication.class, args);
	}

}
