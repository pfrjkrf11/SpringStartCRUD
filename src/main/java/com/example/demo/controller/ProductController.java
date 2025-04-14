package com.example.demo.controller;


import com.example.demo.dto.ProductDto;
import com.example.demo.error.UserException;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
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
    public String addProduct(@Valid @RequestBody ProductDto product) throws Exception{
        service.addProduct(product);
        return "Product added!";
    }

    @PutMapping("update_product")
    public String updateProduct(@RequestBody Product product){
        service.updateProduct(product);
        return "Продукт успешно обновлен!";
    }
    @DeleteMapping("delete_product")
    public void deleteProduct(@RequestBody Product product) throws Exception {
        service.deleteProduct(product);
    }

    @GetMapping("/getFirst")
    public Product getFirst() throws Exception {
        return service.getFirstProduct();
    }

}
