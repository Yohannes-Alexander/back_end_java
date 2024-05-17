// package com.example.xx2.controller;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Component;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.xx2.model.Product;
// import com.example.xx2.model.Users;
// import com.example.xx2.payload.UserRequestCreateDto;
// import com.example.xx2.payload.UserResponseDto;
// import com.example.xx2.service.ProductServiceImpl;
// import com.example.xx2.service.UserServiceImpl;

// @Component
// @RestController
// @RequestMapping("product")
// public class ProductController {
//     @Autowired ProductServiceImpl prodService;

//     public ProductController(ProductServiceImpl prodService){
//         this.prodService = prodService;
//     }

//     @PostMapping
//     public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserRequestCreateDto userRequestCreateDto){
//         Map<String, Object> response = new HashMap<>();
//         response.put("status", "success");

//         Map<String, Object> data = new HashMap<>();
//         Users user = userService.create(userRequestCreateDto);
//         UserResponseDto userResponseDto = new UserResponseDto();
//         userResponseDto.setEmail(user.getEmail());
//         userResponseDto.setUsername(user.getUsername());
//         data.put("user", userResponseDto);

//         response.put("data", data);

//         return new ResponseEntity<>(response, HttpStatus.CREATED);
//     }

//     public void createUser(){
//         Product product = new Product(UUID.randomUUID(), "Nasi Goreng", null, 0, null, null)
//         // merchant.setCreatedDate(LocalDateTime.now());
//         userService.create(user);
//     }

//     public void updatePassword(){
//         Users user = userService.getUsers(UUID.fromString("d2d2262f-3d96-49eb-a22d-b0d37334baae"));
//         // merchant.setCreatedDate(LocalDateTime.now());
//         userService.edit(user, "tutup");
//     }

//     public void deleteUser(){
//         Users user = userService.getUsers(UUID.fromString("d2d2262f-3d96-49eb-a22d-b0d37334baae"));
//         userService.delete(user);
//     }
// }
