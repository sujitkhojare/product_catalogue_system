package com.product_catalogue_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product_catalogue_system.entity.Availability;
import com.product_catalogue_system.service.AvailabilityService;

@RestController
@RequestMapping("/availabilities")
public class AvailabilityController {
     private final AvailabilityService availabilityService;

    @Autowired
    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @PostMapping
    public Availability saveAvailability(@RequestBody Availability availability) {
        return availabilityService.saveAvailability(availability);
    }
}
