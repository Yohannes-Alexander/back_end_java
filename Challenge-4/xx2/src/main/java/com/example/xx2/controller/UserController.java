package com.example.xx2.controller;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.xx2.model.Merchant;
import com.example.xx2.model.Users;
import com.example.xx2.service.UserServiceImpl;

@Component
public class UserController {
    @Autowired UserServiceImpl userService;
    public void createUser(){
        Users user = new Users(UUID.randomUUID(), "yohannesalexander", "user@gmail.com", "123", null);
        // merchant.setCreatedDate(LocalDateTime.now());
        userService.create(user);
    }

    public void updatePassword(){
        Users user = userService.getUsers(UUID.fromString("d2d2262f-3d96-49eb-a22d-b0d37334baae"));
        // merchant.setCreatedDate(LocalDateTime.now());
        userService.edit(user, "tutup");
    }

    public void deleteUser(){
        Users user = userService.getUsers(UUID.fromString("d2d2262f-3d96-49eb-a22d-b0d37334baae"));
        userService.delete(user);
    }
}
