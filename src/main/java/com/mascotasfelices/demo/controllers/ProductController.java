package com.mascotasfelices.demo.controllers;

import com.mascotasfelices.demo.dao.IProductDAO;
import com.mascotasfelices.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private IProductDAO productController;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id){
        Optional<Product> pr = productController.findById(id);
        if(pr.isPresent()) {
            return ResponseEntity.ok(pr.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<Iterable<Product>> getAllProducts(){
        var products = productController.findAll();
        return ResponseEntity.ok(products);
    }

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody Product pr){
        Product prr = productController.save(pr);
        return ResponseEntity.status(HttpStatus.CREATED).body(prr);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id){
        productController.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
