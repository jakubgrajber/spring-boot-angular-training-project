package com.jgrajber.ecommerce.utility;

import com.jgrajber.ecommerce.dao.ProductCategoryRepository;
import com.jgrajber.ecommerce.dao.ProductRepository;
import com.jgrajber.ecommerce.entity.Product;
import com.jgrajber.ecommerce.entity.ProductCategory;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private ProductCategoryRepository productCategoryRepository;
    private ProductRepository productRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ProductCategory books = new ProductCategory("BOOKS");
        productCategoryRepository.save(books);
        productRepository.save(new Product("BOOK-TECH-1000", "JavaScript - The Fun Parts", "Learn JavaScript", "assets/images/products/placeholder.png", true, 100, BigDecimal.valueOf(19.99), books));
        productRepository.save(new Product("BOOK-TECH-1001", "Spring Framework Tutorial", "Learn Spring", "assets/images/products/placeholder.png", true, 100, BigDecimal.valueOf(29.99), books));
        productRepository.save(new Product("BOOK-TECH-1002", "Kubernetes - Deploying Containers", "Learn Kubernetes", "assets/images/products/placeholder.png", true, 100, BigDecimal.valueOf(24.99), books));
        productRepository.save(new Product("BOOK-TECH-1003", "Internet of Things (IoT) - Getting Started", "Learn IoT", "assets/images/products/placeholder.png", true, 100, BigDecimal.valueOf(29.99), books));
        productRepository.save(new Product("BOOK-TECH-1004", "The Go Programming Language: A to Z", "Learn Go", "assets/images/products/placeholder.png", true, 100, BigDecimal.valueOf(24.99), books));

    }
}
