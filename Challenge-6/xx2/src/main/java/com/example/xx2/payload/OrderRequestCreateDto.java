package com.example.xx2.payload;

import lombok.Data;
import java.util.List;
import java.util.UUID;


@Data
public class OrderRequestCreateDto {
    private String destination_address;
    private UUID id_users;
    private List<OrderDetailRequestCreateDto> orderDetail;
}
