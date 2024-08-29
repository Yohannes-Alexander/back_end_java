package com.example.xx2.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.xx2.model.Users;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID>{
    Optional<Users> findByUsername(String username);
}
