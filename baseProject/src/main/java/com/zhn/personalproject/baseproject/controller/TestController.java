package com.zhn.personalproject.baseproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/testController")
    public String test() {
        return "Hello, logging!";
    }
}
