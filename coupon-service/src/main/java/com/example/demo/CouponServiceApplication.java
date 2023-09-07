package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.model.Coupon;
import com.example.demo.repos.CouponRepo;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableEurekaClient
@AllArgsConstructor
public class CouponServiceApplication {
	private final CouponRepo couponRepo;

	public static void main(String[] args) {
		SpringApplication.run(CouponServiceApplication.class, args);
	}

	@PostConstruct
	public void setUp() {

		List<Coupon> coupons = new ArrayList<Coupon>();
		coupons.add(Coupon.builder().code("code-1").discount(new BigDecimal(1000)).expDate("02-02-2024").build());
		coupons.add(Coupon.builder().code("code-2").discount(new BigDecimal(2000)).expDate("02-02-2024").build());
		couponRepo.saveAll(coupons);
	}
}
