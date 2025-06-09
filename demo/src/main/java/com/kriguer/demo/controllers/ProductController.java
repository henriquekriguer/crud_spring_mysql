package com.kriguer.demo.controllers;

import com.kriguer.demo.domain.product.Product;
import com.kriguer.demo.domain.product.ProductRepository;
import com.kriguer.demo.domain.product.RequestProduct;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.util.Optional;

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
    @PutMapping
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProduct data ){
        Optional<Product> product = productRepository.findById(data.id());
        if(product.isPresent()){
            Product existingProduct = product.get();
            existingProduct.setName(data.name());
            existingProduct.setPrice_in_cents(data.price_in_cents());
            return ResponseEntity.ok(existingProduct);
        } else{
            throw new EntityNotFoundException("Product not found");
        }
    }
}
