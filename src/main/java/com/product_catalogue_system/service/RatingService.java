package com.product_catalogue_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product_catalogue_system.entity.Rating;
import com.product_catalogue_system.repository.RatingRepository;

@Service
public class RatingService {

	  private final RatingRepository ratingRepository;

	    @Autowired
	    public RatingService(RatingRepository ratingRepository) {
	        this.ratingRepository = ratingRepository;
	    }

	    public Rating saveRating(Rating rating) {
	        return ratingRepository.save(rating);
	    }
	}


