package com.claupereirajr.product_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claupereirajr.product_ms.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    
}