package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.Coupon;
import com.example.demo.model.Product;
import com.example.demo.repos.ProductRepo;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/productapi")
@AllArgsConstructor
public class ProductRestController {

	private final ProductRepo repo;

	private final RestTemplate restTemplate;

	@PostMapping("/products")
	public Product create(@RequestBody Product product) {
		Coupon coupon = restTemplate.getForObject("http://localhost:8082/couponapi/coupons/" + product.getCouponCode(),
				Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);

	}

	@GetMapping
	public ResponseEntity<?> getStatus() {
		return ResponseEntity.ok("status is up");
	}

}
