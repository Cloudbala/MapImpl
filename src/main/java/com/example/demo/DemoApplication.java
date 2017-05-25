package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		//System.out.println("args = " + args);
		SpringApplication.run(DemoApplication.class, args);
		ConcurrentHasMapImpl chi = new ConcurrentHasMapImpl();
		chi.process();
		System.out.println("Test");

	}
}
