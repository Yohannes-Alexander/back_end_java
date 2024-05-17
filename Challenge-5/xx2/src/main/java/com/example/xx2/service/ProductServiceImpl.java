package com.example.xx2.service;

import org.springframework.stereotype.Service;

import com.example.xx2.model.Product;
import com.example.xx2.repository.ProductRepository;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product create(Product product){
        product = productRepository.save(product);
        return product;
    }

    @Override
    public Product edit(Product product, int harga){
        product.setHarga(harga);
        product = productRepository.save(product);
        return product;
    }

    @Override
    public void delete(Product product){
        productRepository.delete(product);
    }

    @Override
    public Product getProduct(UUID uuid){
        Optional<Product> productOptional = productRepository.findById(uuid);
        if(productOptional.isEmpty()){
            throw new RuntimeException();
        }
        return productOptional.get();
    }

    @Override
    public List<Product> getProductsList(){
        return productRepository.findAll();
    }

    



}
