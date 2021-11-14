package com.stortor.webhomework3.repositories;

import com.stortor.webhomework3.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "Milk", 80),
                new Product(2L, "Bread", 90),
                new Product(3L, "Apples", 100),
                new Product(4L, "Sugar", 50),
                new Product(5L, "Lamb", 170)
        ));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
