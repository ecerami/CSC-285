package edu.bhcc.todo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {
    private TodoRepository repo;

    /**
     * Create Todo Controller.
     */
    public TodoController(TodoRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Todo> todoList = getAllTodos();
        model.addAttribute("todo_list", todoList);
        return "index";
    }

    @GetMapping("/add_todo")
    public String addTodo(String text, String project, Model model) {
        if (text == null || text.length() ==0) {
            text = "--------";
        }
        if (project == null || project.length() == 0) {
            project = "--------";
        }
        Todo todo = new Todo(text, project);
        repo.save(todo);
        List<Todo> todoList = getAllTodos();
        model.addAttribute("toast", "New todo added:  " + text + ".");
        model.addAttribute("todo_list", todoList);
        return "index";
    }

    @GetMapping("/toggle_todo")
    public String toggleTodo(Integer id, Model model) {
        Todo todo = this.repo.findById(id);
        if (todo != null) {
            model.addAttribute("toast", "Toggled todo:  " + todo.getText() + ".");
            todo.setCompleted(!todo.getCompleted());
            this.repo.save(todo);
        } else {
            model.addAttribute("toast", "Could not toggle ID: " + id + ".");
        }

        List<Todo> todoList = getAllTodos();
        model.addAttribute("todo_list", todoList);
        return "index";
    }

    @GetMapping("/delete_todo")
    public String deleteTodo(Integer id, Model model) {
        Todo todo = this.repo.findById(id);
        if (todo != null) {
            model.addAttribute("toast", "Deleted todo:  " + todo.getText() + ".");
            this.repo.delete(todo);
        } else {
            model.addAttribute("toast", "Could not delete ID: " + id + ".");
        }

        List<Todo> todoList = getAllTodos();
        model.addAttribute("todo_list", todoList);
        return "index";
    }

    private List<Todo> getAllTodos() {
        Iterable<Todo> todoIter = repo.findAll();
        List<Todo> todoList = new ArrayList<>();
        for (Todo currentTodo : todoIter) {
            todoList.add(currentTodo);
        }
        return todoList;
    }

}
