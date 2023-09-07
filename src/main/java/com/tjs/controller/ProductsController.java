package com.tjs.controller;

import com.tjs.entity.Products;
import com.tjs.repository.ProductsRepository;
import com.tjs.service.ProductsService; // Import the ProductsService class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/products")
public class ProductsController {
    
    private final ProductsRepository productsRepository;
    private final ProductsService productsService; // Inject ProductsService

    @Autowired
    public ProductsController(ProductsRepository productsRepository, ProductsService productsService) {
        this.productsRepository = productsRepository;
        this.productsService = productsService; // Initialize ProductsService
    }

    @GetMapping
    public List<Products> getAllProducts() {
        return (List<Products>) productsRepository.findAll();
    }

    @GetMapping("/{productId}")
    public Optional<Products> getProductById(@PathVariable int productId) {
        return productsRepository.findById(productId);
    }
    
    @GetMapping("/search-by-name")
    public List<Products> searchProductsByName(@RequestParam String productName) {
        return productsService.findProductsByName(productName); // Use ProductsService method
    }

    @GetMapping("/search-by-category")
    public List<Products> searchProductsByCategory(@RequestParam String category) {
        return productsService.findProductsByCategory(category); // Use ProductsService method
    }

    @GetMapping("/search-by-brand")
    public List<Products> searchProductsByBrand(@RequestParam String brand) {
        return productsService.findProductsByBrand(brand); // Use ProductsService method
    }

    @PostMapping
    public Products createProduct(@RequestBody Products product) {
        return productsRepository.save(product);
    }

    @PutMapping("/{productId}")
    public Products updateProduct(@PathVariable int productId, @RequestBody Products updatedProduct) {
        return productsRepository.findById(productId)
                .map(existingProduct -> {
                    existingProduct.setProductName(updatedProduct.getProductName());
                    existingProduct.setCategory(updatedProduct.getCategory());
                    existingProduct.setBrand(updatedProduct.getBrand());
                    existingProduct.setPrice(updatedProduct.getPrice());
                    existingProduct.setQuantity(updatedProduct.getQuantity());
                    existingProduct.setImageUrl(updatedProduct.getImageUrl());
                    return productsRepository.save(existingProduct);
                })
                .orElseThrow(() -> new IllegalArgumentException("Product with ID " + productId + " not found"));
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        productsRepository.deleteById(productId);
    }
}
