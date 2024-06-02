package com.example.xx2.payload;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class OrderDetailResponseDto {
    private UUID id_product;
    private int quantity;
    private int total_quantity;
}
