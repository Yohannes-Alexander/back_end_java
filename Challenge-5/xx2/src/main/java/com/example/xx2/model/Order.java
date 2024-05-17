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
@Table(name = "orders")
public class Order extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String destination_adress;
    private boolean completed;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetail;

    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name = "id_users")
    private Users user;
}
