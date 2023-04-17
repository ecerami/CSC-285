package edu.bhcc.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

/**
 * Simple Command Line Tool for Todo Database.
 */
public class CommandLineTodo implements CommandLineRunner {
    private TodoRepository repository;
    private static final Logger log = LoggerFactory.getLogger(CommandLineTodo.class);

    /**
     * Create new Command Line DB Tool
     */
    public CommandLineTodo(TodoRepository repository) {
        this.repository = repository;
    }

    /**
     * Run the Command Line Tool.
     */
    @Override
    public void run(String... args) throws Exception {
        // Start with Clean Slate
        this.repository.deleteAll();

        // Add new records
        saveTodos();

        // Get Records
        getAll();

        // Update Records
        updateByProject("personal");
    }

    /**
     * Save a few Todo Items.
     */
    private void saveTodos() {
        log.info("Saving todos.");
        this.repository.save(new Todo("Buy Milk", "personal"));
        this.repository.save(new Todo("Walk Dog", "personal"));
        this.repository.save(new Todo("Create pitch deck", "work"));
        this.repository.save(new Todo("Complete HW6", "school"));
    }

    /**
     * Get all todos.
     */
    private void getAll() {
        log.info("Todos found with findAll():");
        log.info("-------------------------------");
        Iterable<Todo> todoList = repository.findAll();
        for (Todo currentTodo : todoList) {
            log.info(currentTodo.toString());
        }
    }


    /**
     * Fetch todos by project.
     */
    private void updateByProject(String project) {
        log.info("--------------------------------------------");
        log.info("Updating personal todos, marking as complete.");
        List<Todo> todoList = repository.findByProject("personal");
        for (Todo currentTodo : todoList) {
            currentTodo.setCompleted(true);
            repository.save(currentTodo);
        }
        log.info("Retrieving personal tasks");
        todoList = repository.findByProject("personal");
        for (Todo currentTodo : todoList) {
            log.info(currentTodo.toString());
        }
    }
}