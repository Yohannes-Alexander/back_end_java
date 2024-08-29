package com.example.xx2.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xx2.model.Order;
import com.example.xx2.model.OrderDetail;
import com.example.xx2.model.Product;
import com.example.xx2.payload.OrderDetailRequestCreateDto;
import com.example.xx2.payload.OrderDetailResponseDto;
import com.example.xx2.payload.OrderRequestCreateDto;
import com.example.xx2.payload.OrderResponseDto;
import com.example.xx2.repository.ProductRepository;

@Service
public class OrderFacadeService {
    @Autowired private OrderServiceImpl orderServiceImpl;
    @Autowired private OrderDetailServiceImpl orderDetailServiceImpl;

    // public OrderFacadeService(OrderServiceImpl orderServiceImpl, OrderDetailServiceImpl orderDetailServiceImpl) {
    //     this.orderServiceImpl = orderServiceImpl;
    //     this.orderDetailServiceImpl = orderDetailServiceImpl;
    // }

    public OrderResponseDto placeOrder(OrderRequestCreateDto orderRequestCreateDto){
        Order order = orderServiceImpl.create(orderRequestCreateDto);
        List<OrderDetailResponseDto> orderDetails = new ArrayList<>();
        for (OrderDetailRequestCreateDto detailDTO : orderRequestCreateDto.getOrderDetail()) {
            OrderDetail ord = orderDetailServiceImpl.create(detailDTO, order);
            OrderDetailResponseDto orderDetailResponseDto = new OrderDetailResponseDto();

            orderDetailResponseDto.setId_product(ord.getId());
            orderDetailResponseDto.setQuantity(ord.getQuantity());
            orderDetailResponseDto.setTotal_quantity(ord.getProduct().getHarga()*ord.getQuantity());


            orderDetails.add(orderDetailResponseDto);
        }

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setDestination_address(order.getDestination_adress());
        orderResponseDto.setId_users(order.getUser().getId());
        orderResponseDto.setCompleted(order.isCompleted());
        orderResponseDto.setOrderDetails(orderDetails);
        return orderResponseDto;

    }
}
