package com.product_catalogue_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product_catalogue_system.entity.Availability;
import com.product_catalogue_system.repository.AvailabilityRepository;

@Service
public class AvailabilityService {

    private final AvailabilityRepository availabilityRepository;

    @Autowired
    public AvailabilityService(AvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    public Availability saveAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }
}
