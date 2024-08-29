package com.example.xx2.controller;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.xx2.model.Merchant;
import com.example.xx2.payload.MerchantDto;
import com.example.xx2.payload.MerchantRequestUpdateDto;
import com.example.xx2.payload.MerchantResponseUpdateDto;
import com.example.xx2.service.MerchantServiceImpl;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
// @Slf4j
@RestController
@RequestMapping("merchant")
public class MerchantController {
    @Autowired MerchantServiceImpl merchantService;
    @Autowired ModelMapper modelMapper;

    public MerchantController(MerchantServiceImpl merchantService){
        this.merchantService = merchantService;
    }
    
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<Merchant> getAll(){
        return this.merchantService.getMerchantList();
    }

    @GetMapping("merchant")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Map<String, Object>> getAllMerchant(){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        this.merchantService.getMerchantList().stream()
                .map(merchant -> modelMapper.map(merchant, MerchantDto.class))
                .toList();

        data.put("merchants", merchantService.getMerchantList());
        

        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addMerchant(@RequestBody Merchant merchant){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        data.put("merchant", merchantService.create(merchant));
        response.put("data", data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("dto")
    public List<MerchantDto> getAllDtos(){
        return this.merchantService.getMerchantList().stream()
                .map(merchant -> modelMapper.map(merchant, MerchantDto.class))
                .toList();
    }

    @PutMapping("{id}")
    public ResponseEntity<Map<String, Object>> add(@PathVariable("id") UUID idMerchant, @RequestBody MerchantRequestUpdateDto merchantRequestUpdateDto){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        Merchant merchant = merchantService.edit(idMerchant, merchantRequestUpdateDto.getName(), merchantRequestUpdateDto.getLocation(), merchantRequestUpdateDto.getOpen());

        MerchantResponseUpdateDto merchantResponseUpdateDto = new MerchantResponseUpdateDto();
        merchantResponseUpdateDto.setName(merchant.getName());
        merchantResponseUpdateDto.setLocation(merchant.getLocation());
        merchantResponseUpdateDto.setOpen(merchant.getOpen());
        data.put("merchant", merchantResponseUpdateDto);
        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMerchant(@PathVariable("id") UUID idMerchant) {
        merchantService.delete(idMerchant);
        return ResponseEntity.ok("Merchant successfully deleted.");
    }

}
