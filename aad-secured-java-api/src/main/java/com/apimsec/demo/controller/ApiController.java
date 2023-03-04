package com.apimsec.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/pets")
    public ResponseEntity<List<String>> getPets() {
        List<String> pets = new ArrayList<>();
        pets.add("Polly");
        pets.add("Stitch");
        pets.add("Bubbles");
        return ResponseEntity.ok(pets);
    }

}