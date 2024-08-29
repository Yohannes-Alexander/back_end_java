package com.example.xx2.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.xx2.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,UUID> {
    
}
