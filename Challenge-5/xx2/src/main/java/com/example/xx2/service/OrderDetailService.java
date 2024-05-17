package com.example.xx2.service;

import java.util.UUID;

public interface OrderDetailService {
    OrderDetailService getOrderDetailService(UUID uuid);
    OrderDetailService create(OrderDetailService orderDetailService);

}
