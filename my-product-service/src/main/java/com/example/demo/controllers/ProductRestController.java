package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.Coupon;
import com.example.demo.model.Product;
import com.example.demo.repos.ProductRepo;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

	@Autowired
	private ProductRepo repo;

	/*
	 * @Autowired private RestTemplate restTemplate;
	 * 
	 * @Value("${couponService.url}") private String couponServiceURL;
	 * 
	 * @RequestMapping(value = "/products", method = RequestMethod.POST) public
	 * Product create(@RequestBody Product product) { Coupon coupon =
	 * restTemplate.getForObject(couponServiceURL + product.getCouponCode(),
	 * Coupon.class);
	 * product.setPrice(product.getPrice().subtract(coupon.getDiscount())); return
	 * repo.save(product);
	 * 
	 * }
	 */
	@GetMapping
	public ResponseEntity<?> getStatus()
	{
		return ResponseEntity.ok("status is up");
	}

}
