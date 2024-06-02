package com.example.xx2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.xx2.model.Order;
import com.example.xx2.model.OrderDetail;
import com.example.xx2.payload.OrderRequestCreateDto;
import com.example.xx2.payload.OrderResponseDto;
import com.example.xx2.service.OrderFacadeService;
import com.example.xx2.service.OrderService;
import com.example.xx2.service.ProductServiceImpl;

@Component
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired OrderFacadeService orderFacadeService;

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody OrderRequestCreateDto orderRequestCreateDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            OrderResponseDto orderResponseDto = orderFacadeService.placeOrder(orderRequestCreateDto);
            Map<String, Object> data = new HashMap<>();
            data.put("order", orderResponseDto);
            response.put("status", "success");
            response.put("data", data);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
