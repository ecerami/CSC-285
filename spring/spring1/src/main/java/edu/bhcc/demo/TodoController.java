package edu.bhcc.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @GetMapping("/")
    public String index() {
        return "Welcome to our Todo Application!";
    }
}