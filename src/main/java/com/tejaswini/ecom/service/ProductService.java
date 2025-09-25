package com.tejaswini.ecom.service;

import com.tejaswini.ecom.dao.ProductRepository;
import com.tejaswini.ecom.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> getAllProduct(){
        return repository.findAll();
    }

    public Product getProductById(int id){
        return  repository.findById(id).orElse(null);
    }

    public void addProduct(Product product){
        repository.save(product);
    }

    public void updateProduct(Product product){
        repository.save(product);
    }

    public void deleteProduct(int id){
        repository.deleteById(id);
    }
}
