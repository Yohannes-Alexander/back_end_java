package com.example.xx2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.xx2.model.Product;
import com.example.xx2.payload.ProductRequestCreateDto;
import com.example.xx2.payload.ProductRequestUpdateDto;
import com.example.xx2.payload.ProductResponseDto;
import com.example.xx2.service.ProductServiceImpl;

@Component
@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired ProductServiceImpl prodService;
    // @Autowired private ModelMapper modelMapper;

    public ProductController(ProductServiceImpl prodService){
        this.prodService = prodService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createProduct(@RequestBody ProductRequestCreateDto productRequestCreateDto){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        Product product = prodService.create(productRequestCreateDto);
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId_product(product.getId());
        productResponseDto.setName(product.getName());
        productResponseDto.setHarga(product.getHarga());
        productResponseDto.setId_product(product.getMerchant().getId());
        data.put("product", productResponseDto);

        response.put("data", data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllProducts(){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        List<Product> products = this.prodService.getProductsList();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

       for (Product product : products) {
            ProductResponseDto productResponseDto = new ProductResponseDto();
            productResponseDto.setId_product(product.getId());
            productResponseDto.setName(product.getName());
            productResponseDto.setHarga(product.getHarga());
            productResponseDto.setId_merchant(product.getMerchant().getId()); // Assuming Merchant has a getId() method
            productResponseDtos.add(productResponseDto);
        }

        data.put("products", productResponseDtos);
        
        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateProduct(@PathVariable UUID id, @RequestBody ProductRequestUpdateDto productRequestUpdateDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            Product product = prodService.update(id, productRequestUpdateDto);
            ProductResponseDto productResponseDto = new ProductResponseDto();
            productResponseDto.setId_product(product.getId());
            productResponseDto.setName(product.getName());
            productResponseDto.setHarga(product.getHarga());
            productResponseDto.setId_merchant(product.getMerchant().getId());

            Map<String, Object> data = new HashMap<>();
            data.put("product", productResponseDto);
            response.put("status", "success");
            response.put("data", data);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteProduct(@PathVariable UUID id) {
        Map<String, Object> response = new HashMap<>();
        try {
            prodService.delete(id);
            response.put("status", "success");
            response.put("message", "Product deleted successfully");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
