package com.example.xx2.service;
import com.example.xx2.model.Product;

import java.util.List;
import java.util.UUID;

public interface  ProductService {
    
    List<Product> getProductsList();
    Product create(Product product);
    Product edit(Product product, int harga);
    void delete(Product product);
    Product getProduct(UUID uuid);

    
}
