package com.example.xx2.payload;
import java.util.UUID;

import lombok.Data;

@Data
public class ProductRequestCreateDto {
    private String name;
    private int harga;
    private UUID id_merchant;
}
