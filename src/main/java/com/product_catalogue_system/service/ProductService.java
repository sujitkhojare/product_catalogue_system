package com.product_catalogue_system.service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.product_catalogue_system.entity.Product;
import com.product_catalogue_system.entity.Rating;
import com.product_catalogue_system.repository.ProductRepository;

@Service
@Transactional

public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    // get all product 
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    // get product by id 
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElseThrow();
    }
    // for insertion or creation 
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
   // perform delete operation 
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
   // perform update operation 
    public Product updateProduct(Product updatedProduct) {

        return productRepository.save(updatedProduct);
    } 
    // saerch by searchProductsByName
    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
    // search by  searchProductsByCategory
    public List<Product> searchProductsByCategory(String category) {
        return productRepository.findByCategories(category);
    }
    // pagination and sorting in the product list 
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    
    // for rating the product 
    public void rateProduct(Long productId, Rating rating) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        rating.setProduct(product);
        product.getRatings().add(rating);

        productRepository.save(product);
    }
    
}
