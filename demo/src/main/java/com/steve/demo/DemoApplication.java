package com.steve.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// second CLI runner
	@Bean
	@Order(value = 2)
	public CommandLineRunner runCliProgram() {
		String[] cliArgs = new String[]{"Apple", "Orange", "Cherry"};
		return newArgs -> {
			for (int i = 0; i < cliArgs.length; i++) {
				System.out.println(String.format("#%d fruit: %s", i, cliArgs[i]));
			}
		};
    }

	// first CLI runner
	@Bean
	@Order(value = 1)
	public CommandLineRunner runHelloWorld() {
		return args -> System.out.println("Hello World");
	}
}
