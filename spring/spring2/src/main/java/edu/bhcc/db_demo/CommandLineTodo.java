package edu.bhcc.db_demo;

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
        saveTodos();
        getAll();
        getById();
        getByProject();
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
     * Fetch an individual todo by ID.
     */
    private void getById() {
        Todo todo = repository.findById(1L);
        log.info("Todos found with findById(1L):");
        log.info("--------------------------------");
        log.info(todo.toString());
    }

    /**
     * Fetch todos by project.
     */
    private void getByProject() {
        log.info("Todos found with findByProject('personal'):");
        log.info("--------------------------------------------");
        List<Todo> todoList = repository.findByProject("personal");
        for (Todo currentTodo : todoList) {
            log.info(currentTodo.toString());
        }
    }
}