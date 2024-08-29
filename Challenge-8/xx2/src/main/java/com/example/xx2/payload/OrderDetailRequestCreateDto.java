package com.example.xx2.payload;

import lombok.Data;
import java.util.UUID;

@Data
public class OrderDetailRequestCreateDto {
    private UUID id_product;
    private int quantity;
}
