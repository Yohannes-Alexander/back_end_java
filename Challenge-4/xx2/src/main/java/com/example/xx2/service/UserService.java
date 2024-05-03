package com.example.xx2.service;

import java.util.UUID;

import com.example.xx2.model.Users;

public interface UserService {
    Users create(Users user);
    Users edit(Users user, String password);
    void delete(Users user);
    Users getUsers(UUID uuid);
    // Merchant edit(Merchant merchant, String open);
    // Merchant getMerchant(UUID uuid);
}
