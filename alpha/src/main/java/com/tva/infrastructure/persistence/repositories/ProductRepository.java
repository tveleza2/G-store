package com.tva.infrastructure.persistence.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tva.domain.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,UUID>{

} 
