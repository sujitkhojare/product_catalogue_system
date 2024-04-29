package com.product_catalogue_system.entity;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

@Entity
public class Product { 
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String description;
	    private double price;

	    @ElementCollection
	    private List<String> categories;

	    @ElementCollection
	    @CollectionTable(name = "product_attributes")
	    @MapKeyColumn(name = "attribute_key")
	    @Column(name = "attribute_value")
	    private Map<String, String> attributes;

	    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	    private List<Rating> ratings;

	    @ManyToOne
	    @JoinColumn(name = "availability_id")
	    private Availability availability;

	    public Product() {
	        // Default constructor
	    }
	
		public Long getId() {
			return id;
		}
	
		public void setId(Long id) {
			this.id = id;
		}
	
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}
	
		public String getDescription() {
			return description;
		}
	
		public void setDescription(String description) {
			this.description = description;
		}
	
		public double getPrice() {
			return price;
		}
	
		public void setPrice(double price) {
			this.price = price;
		}
	
		public List<String> getCategories() {
			return categories;
		}
	
		public void setCategories(List<String> categories) {
			this.categories = categories;
		}
	
		public Map<String, String> getAttributes() {
			return attributes;
		}
	
		public void setAttributes(Map<String, String> attributes) {
			this.attributes = attributes;
		}
	
		public List<Rating> getRatings() {
			return ratings;
		}
	
		public void setRatings(List<Rating> ratings) {
			this.ratings = ratings;
		}
	
		public Availability getAvailability() {
			return availability;
		}
	
		public void setAvailability(Availability availability) {
			this.availability = availability;
		}
	    
	}