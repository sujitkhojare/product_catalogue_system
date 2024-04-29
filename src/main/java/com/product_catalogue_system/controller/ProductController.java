package com.product_catalogue_system.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.product_catalogue_system.entity.Availability;
import com.product_catalogue_system.entity.Product;
import com.product_catalogue_system.entity.Rating;
import com.product_catalogue_system.repository.RatingRepository;
import com.product_catalogue_system.service.AvailabilityService;
import com.product_catalogue_system.service.ProductService;

@RestController
//@RequestMapping("/products")
public class ProductController {
     
    private final ProductService productService;
    private final AvailabilityService availabilityService;

    
    @Autowired
    public ProductController(ProductService productService, AvailabilityService availabilityService ) {
        this.productService = productService;
        this.availabilityService = availabilityService;
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
   
    @GetMapping("/getProductById/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    
    @PostMapping("/createProduct")
    public String createProduct(@Valid @RequestBody Product product) {
        Availability availability = product.getAvailability();
        Availability savedAvailability = availabilityService.saveAvailability(availability);
        product.setAvailability(savedAvailability);
        productService.saveProduct(product);
        return "Product inserted successfully";
    }

    
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, 
    		@Valid @RequestBody Product updatedProduct)   {
        Product existingProduct = productService.getProductById(id);

        if (existingProduct != null) {
            updatedProduct.setId(id); // Ensure ID consistency
            productService.updateProduct(updatedProduct);
            return ResponseEntity.ok("Product updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @DeleteMapping("/deleteProduct/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "product deleted succesfully";
    } 
    
    @GetMapping("/search")
    public List<Product> searchProductsByName(@RequestParam String name) {
        return productService.searchProductsByName(name);
    }
    
    @GetMapping("/searchByCategory")
    public List<Product> searchProductsByCategory(@RequestParam String category) {
        return productService.searchProductsByCategory(category);
    }
    
    @GetMapping("/getAllProduct")
    public Page<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return productService.getAllProducts(pageable);
    }
    
    @PostMapping("/rateProduct/{productId}")
    public ResponseEntity<String> rateProduct(@PathVariable Long productId, @RequestBody Rating rating) {
        productService.rateProduct(productId, rating);
        return ResponseEntity.ok("Product rated successfully.");
    }
}