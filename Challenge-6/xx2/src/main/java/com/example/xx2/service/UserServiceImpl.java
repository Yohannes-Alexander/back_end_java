package com.example.xx2.service;

import com.example.xx2.model.Users;
import com.example.xx2.payload.UserRequestCreateDto;
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
    public Users create(UserRequestCreateDto userRequestCreateDto){
        Users user = new Users();
        user.setEmail(userRequestCreateDto.getEmail());
        user.setUsername(userRequestCreateDto.getUsername());
        user.setPassword(userRequestCreateDto.getPassword());
        user = userRepository.save(user);
        return user;
    }

    @Override
    public Users edit(UUID uuid, String newPassword){
        Users user = userRepository.findById(uuid).get();
        user.setPassword(newPassword);
        user = userRepository.save(user);
        return user;
    }

    @Override
    public void delete(UUID uuid){
        Users user = userRepository.findById(uuid).get();
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
