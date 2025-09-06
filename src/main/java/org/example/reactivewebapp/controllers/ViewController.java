package org.example.reactivewebapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {

    @GetMapping("/")
    private String index() {
        return "Hello, user!!";
    }

}
