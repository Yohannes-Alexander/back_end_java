package com.example.xx2.service;

import java.util.List;
import java.util.UUID;

import com.example.xx2.model.Order;
import com.example.xx2.payload.OrderRequestCreateDto;

public interface OrderService {
    List<Order> getOrdersList();
    Order create(OrderRequestCreateDto orderRequestCreateDto);
    // Order update(UUID id, OrderRequestUpdateDto orderRequestUpdateDto);
    void delete(UUID id);
    Order getOrderById(UUID id);

}
