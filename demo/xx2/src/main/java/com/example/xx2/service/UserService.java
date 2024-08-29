package com.example.xx2.service;

import java.util.UUID;

import com.example.xx2.model.Users;
import com.example.xx2.payload.UserRequestCreateDto;

public interface UserService {
    Users create(UserRequestCreateDto userRequestCreateDto);
    Users edit(UUID uuid, String newPassword);
    void delete(UUID uuid);
    Users getUsers(UUID uuid);
    // Merchant edit(Merchant merchant, String open);
    // Merchant getMerchant(UUID uuid);
}
