package com.example.xx2.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "id_order")
    private Order order;
    
    private int quantity;



}
