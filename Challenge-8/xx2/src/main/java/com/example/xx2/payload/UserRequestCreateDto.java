package com.example.xx2.payload;
import lombok.Data;

@Data
public class UserRequestCreateDto {
    private String email;
    private String password;
    private String username;
}
