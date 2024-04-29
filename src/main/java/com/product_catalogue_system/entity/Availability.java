package com.product_catalogue_system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Availability {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    // Initialize inStock field with the default value
	    @Column(name = "in_stock", columnDefinition = "boolean default true")
	    private boolean inStock = true;
	    
	    private int quantity;
	    
	    public Availability() {
	        // Default constructor
	    }

	    public Availability(boolean inStock, int quantity) {
	        this.inStock = inStock;
	        this.quantity = quantity;
	    }

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public boolean isInStock() {
				return inStock;
			}

			public void setInStock(boolean inStock) {
				this.inStock = inStock;
			}

			public int getQuantity() {
				return quantity;
			}

			public void setQuantity(int quantity) {
				this.quantity = quantity;
			}	    
	}