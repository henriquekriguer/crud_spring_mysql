package com.kriguer.demo.controllers;

import com.kriguer.demo.domain.product.Product;
import com.kriguer.demo.domain.product.ProductRepository;
import com.kriguer.demo.domain.product.RequestProduct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")  // localhost:8080/product
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity getAllProducts(){
        var allProducts = productRepository.findAll();
        return ResponseEntity.ok(allProducts);
        //return ResponseEntity.ok("Aplicação esta rodando !! ");
    }
    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid RequestProduct data ){
        //System.out.println(data);
        Product newProduct = new Product(data);
        productRepository.save(newProduct);

        return ResponseEntity.ok().build();
    }
}
