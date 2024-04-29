package com.product_catalogue_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product_catalogue_system.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
	
}


