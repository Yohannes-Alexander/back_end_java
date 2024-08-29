package com.example.xx2.controller;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.xx2.model.Users;
import com.example.xx2.payload.UserRequestCreateDto;
import com.example.xx2.payload.UserRequestUpdateDto;
import com.example.xx2.payload.UserResponseDto;
import com.example.xx2.service.UserServiceImpl;

@Component
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired UserServiceImpl userService;

    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserRequestCreateDto userRequestCreateDto){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        Users user = userService.create(userRequestCreateDto);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setUsername(user.getUsername());
        data.put("user", userResponseDto);

        response.put("data", data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Map<String, Object>> add(@PathVariable("id") UUID idMerchant, @RequestBody UserRequestUpdateDto userRequestUpdateDto){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "successfully update password");

        Map<String, Object> data = new HashMap<>();
        Users user = userService.edit(idMerchant, userRequestUpdateDto.getPassword());

        UserResponseDto userResponseUpdateDto = new UserResponseDto();
        userResponseUpdateDto.setEmail(user.getEmail());
        userResponseUpdateDto.setUsername(user.getUsername());
        data.put("user", userResponseUpdateDto);
        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMerchant(@PathVariable("id") UUID idMerchant) {
        userService.delete(idMerchant);
        return ResponseEntity.ok("User successfully deleted.");
    }

}
