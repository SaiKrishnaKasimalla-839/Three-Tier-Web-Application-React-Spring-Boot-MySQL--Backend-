package com.example.backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/test-hello")
    public String hello() {
        return "Backend is working 🚀";
    }
}
