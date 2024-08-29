package com.example.xx2.payload;

import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
public class OrderResponseDto {
    private UUID id;
    private String destination_address;
    private boolean completed;
    private UUID id_users;
    private List<OrderDetailResponseDto> orderDetails;
}
