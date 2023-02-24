package com.example.jenkinstest.dasibom.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping()
    public String home() {
        return "helloooo222";
    }
}
