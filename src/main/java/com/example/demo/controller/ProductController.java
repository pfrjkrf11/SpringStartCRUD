package com.example.demo.controller;


import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService service;


    @GetMapping
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @PostMapping("save_product")
    public String addProduct(@RequestBody Product product){
        service.addProduct(product);
        return "Product added!";
    }

    @PutMapping("update_product")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }
    @DeleteMapping("delete_product/{title}")
    public String deleteProduct(@PathVariable String title){
        service.deleteProduct(title);
        return "Успешно удален";
    }

}
