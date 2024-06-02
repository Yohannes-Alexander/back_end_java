package com.example.xx2.service;
import com.example.xx2.model.Product;
import com.example.xx2.payload.ProductRequestCreateDto;
import com.example.xx2.payload.ProductRequestUpdateDto;

import java.util.List;
import java.util.UUID;

public interface  ProductService {
    
    List<Product> getProductsList();
    Product create(ProductRequestCreateDto productRequestCreateDto);
    Product update(UUID id, ProductRequestUpdateDto productRequestUpdateDto);
    void delete(UUID id);
    Product getProduct(UUID uuid);

    
}
