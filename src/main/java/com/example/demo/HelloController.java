package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    private List<String> todos = new ArrayList<>();

    public HelloController() {
        todos.add("Javaを勉強する");
        todos.add("Spring Bootを勉強する");
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("todos", todos);
        return "todo";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String task) {
        todos.add(task);
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String deleteTodo(@RequestParam int index) {
        if (index >= 0 && index < todos.size()) {
            todos.remove(index);
        }
        return "redirect:/";
    }


}
