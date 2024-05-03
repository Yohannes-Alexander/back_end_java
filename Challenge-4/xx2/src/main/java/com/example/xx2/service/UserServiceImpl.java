package com.example.xx2.service;

import com.example.xx2.model.Users;
import com.example.xx2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public Users create(Users user){
        user = userRepository.save(user);
        return user;
    }

    @Override
    public Users edit(Users user, String password){
        user.setPassword(password);
        user = userRepository.save(user);
        return user;
    }

    @Override
    public void delete(Users user){
        userRepository.delete(user);
    }

    @Override
    public Users getUsers(UUID uuid){
        Optional<Users> userOptional = userRepository.findById(uuid);
        if(userOptional.isEmpty()){
            throw new RuntimeException();
        }
        return userOptional.get();
    }

}
