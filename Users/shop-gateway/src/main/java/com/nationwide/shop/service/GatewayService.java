package com.nationwide.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nationwide.shop.controller.ProductInteraction;
import com.nationwide.shop.dto.ProductDto;

@Service
public class GatewayService {

	@Autowired
	private ProductInteraction productMicroservice;
	
	public List<ProductDto> getAll() {
		return productMicroservice.getAll();
	}
	
	public ProductDto create(ProductDto dto) {
		return productMicroservice.createProduct(dto);
	}
	
	public ProductDto update(ProductDto dto) {
		return productMicroservice.updateProduct(dto);
	}
	
	public String delete(String productName) {
		return productMicroservice.deleteProduct(productName);
	}
}
