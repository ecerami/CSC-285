package edu.bhcc.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class TodoController {
    private TodoRepository repo;

    public TodoController (TodoRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/add")
    public List<Todo> addTodo(String text, String project) {
        List<Todo> todoList = new ArrayList<>();
        Todo todo = new Todo(text, project);
        this.repo.save(todo);
        todoList.add(todo);
        return todoList;
    }

    @GetMapping("/todo")
    public List<Todo> getTodos() {
        List<Todo> todoList = new ArrayList<>();
        Iterator<Todo> recordIterator = repo.findAll().iterator();
        while (recordIterator.hasNext()) {
            todoList.add(recordIterator.next());
        }
        return todoList;
    }

    @GetMapping("/todo/{id}")
    public List<Todo> getTodoById(@PathVariable("id") Integer todoId) {
        List<Todo> todoList = new ArrayList<>();
        Todo todo = repo.findById(todoId);
        if (todo != null) {
            todoList.add(todo);
        }
        return todoList;
    }

    @GetMapping("/todo/project/{project_name}")
    public List<Todo> getTodoByProject(@PathVariable("project_name") String projectName) {
        return repo.findByProject(projectName);
    }


    @GetMapping("/delete/{id}")
    public List<Todo> deleteTodo(@PathVariable("id") Integer todoId) {
        List<Todo> todoList = new ArrayList<>();
        Todo todo = this.repo.findById(todoId);
        if (todo != null) {
            this.repo.delete(todo);
            todoList.add(todo);
        }
        return todoList;
    }

    @GetMapping("/toggle/{id}")
    public List<Todo> toggleTodo(@PathVariable("id") Integer todoId) {
        List<Todo> todoList = new ArrayList<>();
        Todo todo = this.repo.findById(todoId);
        if (todo != null) {
            todo.setCompleted(!todo.getCompleted());
            this.repo.save(todo);
            todoList.add(todo);
        }
        return todoList;
    }
}