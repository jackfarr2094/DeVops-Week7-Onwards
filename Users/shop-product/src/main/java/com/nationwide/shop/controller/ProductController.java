package com.nationwide.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.shop.dto.ProductDto;
import com.nationwide.shop.persistence.domain.Product;
import com.nationwide.shop.service.ProductService;

import name.christophperrins.users.general.mapping.Mapping;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private Mapping mapping;
	
	@Autowired
	private ProductService service;
	
	@PostMapping
	public ProductDto createProduct(@RequestBody ProductDto dto) {
		Product product = mapping.map(dto, Product.class);
		Product savedItem = service.saveProduct(product);
		return mapping.map(savedItem, ProductDto.class);
	}
	
	@GetMapping
	public List<ProductDto> getAllProducts(){
		List<Product> products = service.showProducts();
		return mapping.map(products, ProductDto.class);
	}
	
	@PutMapping 
	public ProductDto changePrice(@RequestBody ProductDto dto) {
		Product product = mapping.map(dto, Product.class);
		Product modified = service.updateProduct(product);
		return mapping.map(modified, ProductDto.class);
	}
	
	@DeleteMapping("/{productName}") 
	public String deleteProduct(@PathVariable String productName) {
		service.deleteProduct(productName);
		return "deleted";
	}
}
