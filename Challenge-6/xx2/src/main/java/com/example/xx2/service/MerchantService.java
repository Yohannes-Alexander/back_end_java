package com.example.xx2.service;

import java.util.List;
import java.util.UUID;

import com.example.xx2.model.Merchant;


public interface MerchantService {
    List<Merchant> getMerchantList();
    Merchant create(Merchant merchant);
    Merchant edit(UUID uuid, String name, String location, String open);
    Merchant getMerchant(UUID uuid);
    void delete(UUID uuid);
    // MerchantDto create(CinemaCreateRequestDto cinemaCreateRequestDto);
}
