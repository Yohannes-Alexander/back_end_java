package com.example.xx2.model;

import java.util.UUID;
import lombok.*;
import jakarta.persistence.*;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private ERole name;

}


