package com.example.xx2.payload;

import java.util.UUID;
import lombok.Data;

@Data
public class ProductResponseDto {
    private UUID id_product;
    private String name;
    private int harga;
    private UUID id_merchant;
}
