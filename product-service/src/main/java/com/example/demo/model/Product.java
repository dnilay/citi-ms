package com.example.demo.model;

public class Product {
	
	private String productId;
	private String productName;
	private ProductType productType;
	public Product() {
		super();
	}
	public Product(String productId, String productName, ProductType productType) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productType=" + productType
				+ "]";
	}
	
	
	

}
