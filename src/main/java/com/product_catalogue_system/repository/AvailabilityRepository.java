package com.product_catalogue_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product_catalogue_system.entity.Availability;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability,Long> {

	 
}
