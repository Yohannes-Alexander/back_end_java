package com.example.xx2.controller;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.xx2.model.Merchant;
import com.example.xx2.service.MerchantServiceImpl;

import org.springframework.stereotype.Component;

@Component
// @Slf4j
public class MerchantController {
    @Autowired MerchantServiceImpl merchantService;

    public void createMerchant(){
        Merchant merchant = new Merchant(UUID.randomUUID(),"Cabang 1", "Jakarta","Open",null);
        // merchant.setCreatedDate(LocalDateTime.now());
        merchantService.create(merchant);
    }

    public void updateMerchant(){
        Merchant merchant = merchantService.getMerchant(UUID.fromString("8ec2595b-f881-4e0a-8cc4-66844f1f217e"));
        // merchant.setCreatedDate(LocalDateTime.now());
        merchantService.edit(merchant, "tutup");
    }

}
