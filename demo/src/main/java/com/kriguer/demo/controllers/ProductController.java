package com.kriguer.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/product")  // localhost:8080/product
public class ProductController {
    @GetMapping
    public ResponseEntity getAllProducts(){
        return ResponseEntity.ok("Aplicação esta rodando !! ");
    }
}
