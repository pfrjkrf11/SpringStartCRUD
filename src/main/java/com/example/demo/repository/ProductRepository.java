package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


@Repository
public class ProductRepository {
    private final List<Product> PRODUCTS = new ArrayList<>();
    private int globalId;

    public List<Product> getAllProducts() {
        return PRODUCTS;
    }

    public void addProduct(Product product) {
        globalId++;
        product.setId(globalId);
        PRODUCTS.add(product);
    }

    public Product updateProduct(Product product) {
        Product searchingProduct = findProduct(product);
        if (searchingProduct != null) {
            searchingProduct.setPrice(product.getPrice());
            searchingProduct.setTitle(product.getTitle());
        }
        return searchingProduct;
    }

    public boolean deleteProduct(Product product) {
        return PRODUCTS.remove(product);
    }

    public Product getFirst() {
        return PRODUCTS.get(0);
    }

    public Product findProduct(Product product) {
        return PRODUCTS.stream().filter(pr -> pr.getId() == product.getId()).findFirst().orElse(null);
    }
}
