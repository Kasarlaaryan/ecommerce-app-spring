package com.stschool.ecommerce.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class HellloController {
    @GetMapping("/hello")
    public String hello(){
        System.out.println("HTTP GET REQUEST");
        return "Hello Wprld! -> Get";
    }
    @PostMapping("/hello")
    public String helloPut(){
        System.out.println("HTTP GET PUT ");
        return "Hello world ! -> put";
    }

    @PatchMapping("/hello")
    public String helloPatch(){
        System.out.println("HTTP GET Patch ");
        return "Hello world ! -> Patch";
    }

    @DeleteMapping("/hello")
    public String helloDelete(){
        System.out.println("HTTP GET Delete ");
        return "Hello world ! -> Delete";
    }

}
