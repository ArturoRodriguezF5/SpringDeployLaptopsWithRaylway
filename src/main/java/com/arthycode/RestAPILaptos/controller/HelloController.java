package com.arthycode.RestAPILaptos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String saludo() {
        return "Hola desde HelloController";
    }
}
