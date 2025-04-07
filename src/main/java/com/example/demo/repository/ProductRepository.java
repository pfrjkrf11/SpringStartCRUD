package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


@Repository
public class ProductRepository {
    private final List<Product> PRODUCTS = new ArrayList<>();

    public List<Product> getAllProducts(){
        return PRODUCTS;
    }

    public Product addProduct(Product product){
        PRODUCTS.add(product);
        return product;
    }

    public Product updateProduct(Product product){
        Product searchingProduct = PRODUCTS.stream().filter(pr -> pr.getId()==product.getId()).findFirst().orElse(null);
        if(searchingProduct!=null){
            searchingProduct.setPrice(product.getPrice());
            searchingProduct.setTitle(product.getTitle());
        }
        return searchingProduct;
    }

    public void deleteProduct(String title){
        Product searchingProduct = PRODUCTS.stream().filter(pr -> pr.getTitle().equals(title)).findFirst().orElse(null);
        if(searchingProduct!=null){
            PRODUCTS.remove(searchingProduct);
        }
    }
}
