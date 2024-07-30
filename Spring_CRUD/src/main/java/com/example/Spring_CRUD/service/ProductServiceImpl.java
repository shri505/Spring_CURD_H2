package com.example.Spring_CRUD.service;

import com.example.Spring_CRUD.model.Product;
import com.example.Spring_CRUD.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class ProductServiceImpl implements ProductService{


    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {


        Optional<Product> productDb = this.productRepository.findById(product.getId());


        if (productDb.isPresent()) {
            Product productupdate = productDb.get();
            productupdate.setId(product.getId());
            productupdate.setName(product.getName());
            productupdate.setDescription(product.getDescription());
            productRepository.save(productupdate);
            return productupdate;
        } else {
            throw new RuntimeException("Record not found with id : " + product.getId());

        }
    }


    @Override
    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(long productId) {

        Optional<Product> productDb = this.productRepository.findById(productId);

        if(productDb.isPresent()){
            return productDb.get();
        }else {
            throw new RuntimeException("Record not found with id : " + productId);

        }

    }

    @Override
    public void deleteProduct(long id) {

        Long productId = null;
        Optional<Product> productDb = this.productRepository.findById(productId);

        if(productDb.isPresent()){
            this.productRepository.delete(productDb.get());
        }else {

            throw new RuntimeException("Record not found with id : " + productId);

        }

    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
