package com.example.xx2.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;
import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "merchant")
public class Merchant extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String location;
    private String open;

    @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL)
    private List<Product> productList;
}
