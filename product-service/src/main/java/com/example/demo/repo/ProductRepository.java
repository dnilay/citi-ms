package com.example.demo.repo;

import java.util.Collection;

import com.example.demo.model.Product;

public interface ProductRepository {
	
	Product createProduct(Product product);
	Collection<Product> getAllProducts();

}
