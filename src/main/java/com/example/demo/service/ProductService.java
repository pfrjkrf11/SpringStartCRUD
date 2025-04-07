package com.example.demo.service;


import com.example.demo.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ProductRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository repository;


    public List<Product> getAllProducts(){
        return repository.getAllProducts();
    }

    public Product addProduct(Product product){
        repository.addProduct(product);
        return product;
    }

    public Product updateProduct(Product product){
        repository.updateProduct(product);
        return product;
    }

    public void deleteProduct(String title){
        repository.deleteProduct(title);
    }

}
