package com.example.xx2.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xx2.model.Order;
import com.example.xx2.model.OrderDetail;
import com.example.xx2.model.Product;
import com.example.xx2.payload.OrderDetailRequestCreateDto;
import com.example.xx2.repository.OrderDetailRepository;
import com.example.xx2.repository.ProductRepository;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    
    @Override
    public OrderDetail create(OrderDetailRequestCreateDto orderDetailRequestCreateDto, Order order){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(order);
        Product product = productRepository.findById(orderDetailRequestCreateDto.getId_product())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        orderDetail.setProduct(product);        
        orderDetail.setQuantity(orderDetailRequestCreateDto.getQuantity());

        orderDetailRepository.save(orderDetail);
        return orderDetail;

    }
    
}
