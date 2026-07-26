package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		System.out.println("Niraj:- SpringBoot initializer");

		PrintHello controller = new PrintHello();
		String h1 = controller.printHello();
		System.out.println(h1);
	}

}
