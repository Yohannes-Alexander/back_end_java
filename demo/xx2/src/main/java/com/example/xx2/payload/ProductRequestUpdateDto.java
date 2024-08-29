package com.example.xx2.payload;

import lombok.Data;
import java.util.UUID;

@Data
public class ProductRequestUpdateDto {
    private String name;
    private int harga;
    private UUID id_merchant;
}