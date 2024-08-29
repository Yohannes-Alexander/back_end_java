package com.example.xx2.service;

import org.springframework.stereotype.Service;

import com.example.xx2.model.Product;
import java.util.List;
@Service
public class PromotionService {
    public void sendFCM(List<Product> productList){
        System.out.println("Promotion sent to User");
    }
}
