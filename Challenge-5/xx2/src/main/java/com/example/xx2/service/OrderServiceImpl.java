package com.example.xx2.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.xx2.model.Merchant;
import com.example.xx2.model.Order;
import com.example.xx2.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order create (Order order){
        order = orderRepository.save(order);
        return order;
    }

    @Override
    public Order getOrder(UUID uuid){
        Optional<Order> orderOptional= orderRepository.findById(uuid);
        if(orderOptional.isEmpty()){
            throw new RuntimeException();
        }
        return orderOptional.get();
    }



}
