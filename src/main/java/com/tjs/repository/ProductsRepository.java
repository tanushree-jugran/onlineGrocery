package com.tjs.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tjs.entity.Products;

import java.util.List;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Integer> {
    // Add custom query methods here for specific search requirements
    List<Products> findByCategory(String category);
    List<Products> findByBrand(String brand);
    List<Products> findByProductName(String productName);
}
