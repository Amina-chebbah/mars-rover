package com.bnpp.rover;

import com.bnpp.rover.service.RoverController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarsRoverApplication {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Usage: java -jar rover.jar <input_file_path>");
			System.exit(1);
		}
		SpringApplication.run(MarsRoverApplication.class, args);

		RoverController roverController = new RoverController();
		roverController.processInput(args[0]);
	}

}
