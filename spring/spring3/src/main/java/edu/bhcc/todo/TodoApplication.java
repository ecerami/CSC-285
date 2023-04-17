package edu.bhcc.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoApplication {

	/**
	 * Initialize Spring Application.
	 */
    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

	/**
	 * Access the Database via Command Line.
	 */
	@Bean
	public CommandLineRunner runDemo(TodoRepository repository) {
		return new CommandLineTodo(repository);
	}
}