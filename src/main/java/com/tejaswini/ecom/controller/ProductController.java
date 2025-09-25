package com.tejaswini.ecom.controller;

import com.tejaswini.ecom.model.Product;
import com.tejaswini.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public String greet(){
        return "Hi....!!! welcome to my world";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        System.out.println("calling this");
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        Product product = productService.getProductById(id);
        if(product != null)
        return  new ResponseEntity<>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/products")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProductById(@PathVariable int id,@RequestBody Product product){
        Product product1 = productService.getProductById(id);
        if(product1 != null){
            productService.updateProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product1 = productService.getProductById(id);
        if(product1 != null) {
            productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
