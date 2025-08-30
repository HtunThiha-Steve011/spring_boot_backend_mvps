package com.steve.demo;

import com.steve.demo.data.RoomEntity;
import com.steve.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	RoomRepository roomRepository;

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

	@Bean
	@Order(value = 3)
	public CommandLineRunner printAllRooms() {
		return args -> {
			List<RoomEntity> roomsList = roomRepository.findAll();
			System.out.println("===== ROOMS Table =====");
			for (RoomEntity room : roomsList) {
				System.out.println(String.format("%s\t%s\t%s\t%s\t",
						room.getRoomId().toString(),
						room.getName(),
						room.getNumber(),
						room.getBedInfo()
						));
			}
		};
	}
}
