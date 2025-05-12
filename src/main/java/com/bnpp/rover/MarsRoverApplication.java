package com.bnpp.rover;

import com.bnpp.rover.service.RoverController;

import java.util.List;

public class MarsRoverApplication {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Usage: java -jar mars-rover.jar <input_file_path>");
			System.exit(1);
		}

		String inputFilePath = args[0];
		RoverController controller = new RoverController();
		List<String> results = controller.processMission(inputFilePath);

		if (results.isEmpty()) {
			System.out.println("No valid rover output. Check input file or error logs.");
		} else {
			results.forEach(System.out::println);
		}
	}
}
