package com.example.demo.controllers;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Coupon;
import com.example.demo.repos.CouponRepo;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CouponRestController {

	private final CouponRepo repo;

	private final Environment environment;

	@GetMapping
	public ResponseEntity<?> status() {
		return ResponseEntity
				.ok("coupon-service is up and runing on port: " + environment.getProperty("local.server.port"));
	}

	@PostMapping("/coupons")
	public Coupon create(@RequestBody Coupon coupon) {

		return repo.save(coupon);

	}

	@GetMapping("/coupons/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
		return repo.findByCode(code);

	}
}
