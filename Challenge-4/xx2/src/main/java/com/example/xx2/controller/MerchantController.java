package com.example.xx2.controller;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.xx2.model.Merchant;
import com.example.xx2.service.MerchantServiceImpl;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
// @Slf4j
@RestController
@RequestMapping("merchant")
public class MerchantController {
    @Autowired MerchantServiceImpl merchantService;

    public MerchantController(MerchantServiceImpl merchantService){
        this.merchantService = merchantService;
    }

    @GetMapping
    public List<Merchant> getAll(){
        return this.merchantService.getMerchantList();
    }

    @GetMapping("merchant")
    public ResponseEntity<Map<String, Object>> getAllMerchant(){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        Map<String, Object> data = new HashMap<>();
        data.put("merchants", merchantService.getMerchantList());

        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<Map<String, Object>> addMerchant(@RequestBody Merchant merchant){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        data.put("merchant", merchantService.create(merchant));
        response.put("data", data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

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
