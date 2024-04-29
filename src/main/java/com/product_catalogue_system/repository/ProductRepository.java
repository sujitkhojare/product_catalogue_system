package com.product_catalogue_system.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product_catalogue_system.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
 
    List<Product> findByNameContainingIgnoreCase(String name);
    
    List<Product> findByCategories(String category);
    
}

	



