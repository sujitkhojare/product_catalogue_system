package com.product_catalogue_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product_catalogue_system.entity.Rating;
import com.product_catalogue_system.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
      
    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public Rating saveRating(@RequestBody Rating rating) {
        return ratingService.saveRating(rating);
    }
}
