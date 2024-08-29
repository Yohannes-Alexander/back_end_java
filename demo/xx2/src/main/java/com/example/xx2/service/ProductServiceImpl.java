package com.example.xx2.service;

import org.springframework.stereotype.Service;

import com.example.xx2.model.Merchant;
import com.example.xx2.model.Product;
import com.example.xx2.model.Users;
import com.example.xx2.payload.ProductRequestCreateDto;
import com.example.xx2.payload.ProductRequestUpdateDto;
import com.example.xx2.repository.MerchantRepository;
import com.example.xx2.repository.ProductRepository;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    public List<Product> getProductsList() {
        return productRepository.findAll();
    }
    @Override
    public Product create(ProductRequestCreateDto productRequestCreateDto){
        
        Product product = new Product();
        product.setName(productRequestCreateDto.getName());
        product.setHarga(productRequestCreateDto.getHarga());
        // Fetch the Merchant entity
        Merchant merchant = merchantRepository.findById(productRequestCreateDto.getId_merchant())
            .orElseThrow(() -> new RuntimeException("Merchant not found"));

        product.setMerchant(merchant);
        product = productRepository.save(product);
        return product;
    }

    @Override
    public Product update(UUID id, ProductRequestUpdateDto productRequestUpdateDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productRequestUpdateDto.getName());
        product.setHarga(productRequestUpdateDto.getHarga());

        Merchant merchant = merchantRepository.findById(productRequestUpdateDto.getId_merchant())
                .orElseThrow(() -> new RuntimeException("Merchant not found"));

        product.setMerchant(merchant);

        return productRepository.save(product);
    }

    @Override
    public void delete(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

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


    



}
