package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.service.CalcService;

@RestController
@RequestMapping("/calculator")
public class CalcController {

    @Autowired
    private CalcService service;

    // ADDITION - RequestParam
    // http://localhost:8080/calculator/add?a=10&b=5
    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return service.add(a, b);
    }

    // SUBTRACTION - PathVariable
    // http://localhost:8080/calculator/subtract/20/5
    @GetMapping("/subtract/{a}/{b}")
    public int subtract(@PathVariable int a, @PathVariable int b) {
        return service.subtract(a, b);
    }

    // MULTIPLY - PathVariable
    // http://localhost:8080/calculator/multiply/20/5
    @GetMapping("/multiply/{a}/{b}")
    public int multiply(@PathVariable int a, @PathVariable int b) {
        return service.multiply(a, b);
    }

    // DIVISION - RequestParam
    // http://localhost:8080/calculator/divide?a=10&b=5
    @GetMapping("/divide")
    public double divide(@RequestParam int a, @RequestParam int b) {
        return service.divide(a, b);
    }

    // MODULO - PathVariable
    // http://localhost:8080/calculator/modulo/20/5
    @GetMapping("/modulo/{a}/{b}")
    public int modulo(@PathVariable int a, @PathVariable int b) {
        return service.modulo(a, b);
    }
}
