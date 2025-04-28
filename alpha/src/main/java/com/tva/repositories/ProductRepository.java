package com.tva.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tva.entitiy.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,UUID>{

} 
