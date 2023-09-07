package com.tjs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.tjs.entity.Products;
import com.tjs.repository.ProductsRepository;
import com.tjs.service.ProductsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductsServiceTest {

    @Mock
    private ProductsRepository productsRepository;

    @InjectMocks
    private ProductsService productsService;

    @Test
    public void testFindAllProducts() {
        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(1, "Product 1", "Category 1", "Brand 1", BigDecimal.valueOf(100.0), 10, "image1.jpg"));
        productsList.add(new Products(2, "Product 2", "Category 2", "Brand 2", BigDecimal.valueOf(200.0), 20, "image2.jpg"));

        when(productsRepository.findAll()).thenReturn(productsList);

        List<Products> result = productsService.findAllProducts();

        assertEquals(productsList, result);
    }

    @Test
    public void testFindProductsByCategory() {
        String category = "Category 1";
        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(1, "Product 1", category, "Brand 1", BigDecimal.valueOf(100.0), 10, "image1.jpg"));
        productsList.add(new Products(2, "Product 2", category, "Brand 2", BigDecimal.valueOf(200.0), 20, "image2.jpg"));

        when(productsRepository.findByCategory(category)).thenReturn(productsList);

        List<Products> result = productsService.findProductsByCategory(category);

        assertEquals(productsList, result);
    }

    @Test
    public void testFindProductsByBrand() {
        String brand = "Brand 1";
        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(1, "Product 1", "Category 1", brand, BigDecimal.valueOf(100.0), 10, "image1.jpg"));
        productsList.add(new Products(2, "Product 2", "Category 2", brand, BigDecimal.valueOf(200.0), 20, "image2.jpg"));

        when(productsRepository.findByBrand(brand)).thenReturn(productsList);

        List<Products> result = productsService.findProductsByBrand(brand);

        assertEquals(productsList, result);
    }

    @Test
    public void testFindProductsByName() {
        String productName = "Product 1";
        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(1, productName, "Category 1", "Brand 1", BigDecimal.valueOf(100.0), 10, "image1.jpg"));
        productsList.add(new Products(2, productName, "Category 2", "Brand 2", BigDecimal.valueOf(200.0), 20, "image2.jpg"));

        when(productsRepository.findByProductName(productName)).thenReturn(productsList);

        List<Products> result = productsService.findProductsByName(productName);

        assertEquals(productsList, result);
    }
}
