package com.example.demo.service;


import com.example.demo.dto.ProductDto;
import com.example.demo.error.ServerException;
import com.example.demo.error.UserException;
import com.example.demo.model.Product;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ProductRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository repository;
    private ModelMapper mapper;


    public List<Product> getAllProducts(){
        return repository.getAllProducts();
    }

    public void addProduct(ProductDto product) throws UserException {
        try {
            repository.addProduct(mapper.map(product,Product.class));
        }catch (Exception ex){
            throw new UserException("Неверные данные для ввода","Вы неверно указали поля",0);
        }
    }

    public void updateProduct(Product product){
        repository.updateProduct(product);
    }

    public void deleteProduct(Product product)throws Exception{
        Product product1 = repository.findProduct(product);

        if(product1==null){
            throw new UserException("Продукт не найден","Ошибка при поиске продукта",0);
        }
        try {
            repository.deleteProduct(product1);
        }catch (Exception exception){
            throw new ServerException("Продукт не удален","Ошибка при удалении продукта",0);
        }

    }

    public Product getFirstProduct() throws Exception{
        try {
            return repository.getFirst();
        }catch (Exception ex){
            throw new ServerException("Список продуктов пуст", "Продуктов нет",0);
        }
    }

}
