package edu.bhcc.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class TodoController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required=false,
            defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/todo_single")
    public String todoSingle(Model model) {
        Todo todo = new Todo("Buy Milk", "personal");
        model.addAttribute("todo", todo);
        return "todo_single";
    }

    @GetMapping("/todo_list")
    public String todoList(Model model) {
        ArrayList<Todo> todoList = new ArrayList<>();
        Todo todo0 = new Todo("Buy Milk", "personal");
        Todo todo1 = new Todo("Do homework 6", "school");
        Todo todo2 = new Todo("Finish 2023 Taxes", "money");
        todo1.setCompleted(true);
        todoList.add(todo0);
        todoList.add(todo1);
        todoList.add(todo2);
        model.addAttribute("todo_list", todoList);
        return "todo_list";
    }
}
