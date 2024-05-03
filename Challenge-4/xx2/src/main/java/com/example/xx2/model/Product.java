package com.example.xx2.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")

public class Product extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String address;
    private int harga;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetail;

    @ManyToOne(targetEntity = Merchant.class)
    @JoinColumn(name = "id_merchant")
    private Merchant merchant;
}
