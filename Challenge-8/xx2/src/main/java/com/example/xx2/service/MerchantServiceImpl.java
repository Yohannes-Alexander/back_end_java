package com.example.xx2.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.xx2.model.Merchant;
import com.example.xx2.payload.MerchantDto;
import com.example.xx2.repository.MerchantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MerchantServiceImpl implements MerchantService{

    @Autowired
    MerchantRepository merchantRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Merchant> getMerchantList() {
        return merchantRepository.findAll();
    }

    @Override
    public Merchant create(Merchant merchant){
        merchant = merchantRepository.save(merchant);
        return merchant;
    }

    @Override
    public Merchant edit(UUID uuid, String name, String location, String open){
        Optional<Merchant> merchantOptional= merchantRepository.findById(uuid);
        if(merchantOptional.isEmpty()){
            throw new RuntimeException();
        }
        Merchant merchant = merchantOptional.get();
        if (name!=null){
            merchant.setOpen(open);
        }
        if (location!=null){
            merchant.setLocation(location);
        }
        if(open!=null){
            merchant.setOpen(open);
        }
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

    @Override
    public void delete(UUID uuid){
        merchantRepository.deleteById(uuid);
    }






    

}
