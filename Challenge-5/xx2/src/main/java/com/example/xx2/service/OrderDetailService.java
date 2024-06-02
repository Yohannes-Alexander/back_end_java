package com.example.xx2.service;

import java.util.UUID;

import com.example.xx2.model.Order;
import com.example.xx2.model.OrderDetail;
import com.example.xx2.payload.OrderDetailRequestCreateDto;

public interface OrderDetailService {
    // OrderDetailService getOrderDetailService(UUID uuid);
    OrderDetail create(OrderDetailRequestCreateDto orderDetailRequestCreateDto, Order order);

}
