package com.example.jpa.repository.product;

import com.example.jpa.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT DISTINCT cusipNumber FROM Product")
    List<String> findAllDistinctCusipNumbers();
}
