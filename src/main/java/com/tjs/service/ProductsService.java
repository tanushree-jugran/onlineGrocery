package com.tjs.service;

import com.tjs.entity.Products;
import com.tjs.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Products> findAllProducts() {
        return (List<Products>) productsRepository.findAll();
    }

    public List<Products> findProductsByCategory(String category) {
        return productsRepository.findByCategory(category);
    }

    public List<Products> findProductsByBrand(String brand) {
        return productsRepository.findByBrand(brand);
    }

    public List<Products> findProductsByName(String productName) {
        return productsRepository.findByProductName(productName);
    }
}
