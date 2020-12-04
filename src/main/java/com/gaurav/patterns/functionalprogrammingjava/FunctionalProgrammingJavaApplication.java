package com.gaurav.patterns.functionalprogrammingjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FunctionalProgrammingJavaApplication {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("I am just starting, spring boot application yet not initialized.... managed by thread [" + Thread.currentThread().getName() + "]");
		SpringApplication.run(FunctionalProgrammingJavaApplication.class, args);
		System.out.println("I am still being managed by thread [" + Thread.currentThread().getName() + "]");


	}

}
