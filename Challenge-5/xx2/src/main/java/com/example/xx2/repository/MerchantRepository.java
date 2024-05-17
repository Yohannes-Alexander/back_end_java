package com.example.xx2.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.xx2.model.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, UUID>{

}
