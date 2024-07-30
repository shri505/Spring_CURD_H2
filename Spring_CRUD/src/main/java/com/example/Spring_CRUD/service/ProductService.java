package com.example.Spring_CRUD.service;

import com.example.Spring_CRUD.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    List<Product> getAllProduct();
    Product getProductById(long productId);

    void deleteProduct(long id);

    List<Product> getAllProducts();
}
