package com.example.xx2.service;

import java.util.UUID;

import com.example.xx2.model.Order;

public interface OrderService {
    Order create (Order order);
    Order getOrder (UUID uuid);

}
