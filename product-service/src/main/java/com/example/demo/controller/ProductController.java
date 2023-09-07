package com.example.demo.controller;

import java.util.Collection;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepository;

@RestController
public class ProductController {

	private final ProductRepository productRepository;

	public ProductController(ProductRepository productRepository) {

		this.productRepository = productRepository;
	}

	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		product.setProductId(UUID.randomUUID().toString());
		return productRepository.createProduct(product);

	}

	@GetMapping("/products")
	public Collection<Product> fetchAllProducts() {
		return productRepository.getAllProducts();
	}

}
