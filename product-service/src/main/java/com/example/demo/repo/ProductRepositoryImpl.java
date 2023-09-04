package com.example.demo.repo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.demo.model.Product;

@Component("productRepository")
public class ProductRepositoryImpl implements ProductRepository {

	public Map<String, Product> pMap;

	{
		pMap = new HashMap<String, Product>();

	}

	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		pMap.put(product.getProductId(), product);
		return product;
	}

	@Override
	public Collection<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pMap.values();
	}

}
