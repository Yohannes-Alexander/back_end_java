package com.example.xx2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.xx2.model.Order;
import com.example.xx2.model.OrderDetail;
import com.example.xx2.model.Product;
import com.example.xx2.model.Users;
import com.example.xx2.payload.OrderRequestCreateDto;
import com.example.xx2.repository.OrderRepository;
import com.example.xx2.repository.ProductRepository;
import com.example.xx2.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
   @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository usersRepository;
    
    @Override
    public List<Order> getOrdersList() {
        return orderRepository.findAll();
    }

    @Override
    public Order create(OrderRequestCreateDto orderRequestCreateDto) {
        Order order = new Order();
        order.setDestination_adress(orderRequestCreateDto.getDestination_address());
        order.setCompleted(false);

        Users user = usersRepository.findById(orderRequestCreateDto.getId_users())
                .orElseThrow(() -> new RuntimeException("User not found"));

        order.setUser(user);

        return orderRepository.save(order);
    }

    @Override
    public void delete(UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        orderRepository.delete(order);
    }

    @Override
    public Order getOrderById(UUID id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

}
