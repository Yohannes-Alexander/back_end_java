package com.example.xx2.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.xx2.model.Merchant;
import com.example.xx2.repository.MerchantRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class MerchantServiceImpl implements MerchantService{

    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public Merchant create(Merchant merchant){
        merchant = merchantRepository.save(merchant);
        return merchant;
    }

    @Override
    public Merchant edit(Merchant merchant, String open){
        merchant.setOpen(open);
        merchant = merchantRepository.save(merchant);
        return merchant;
    }

    @Override
    public Merchant getMerchant(UUID uuid){
        Optional<Merchant> merchantOptional= merchantRepository.findById(uuid);
        if(merchantOptional.isEmpty()){
            throw new RuntimeException();
        }
        return merchantOptional.get();

    }


    

}
