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
import com.nationwide.shop.service.GatewayService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class GatewayController {

	@Autowired
	private GatewayService service;
	
	@GetMapping
	public List<ProductDto> getAll() {
		return service.getAll();
	}
	
	@PostMapping
	public ProductDto createProduct(@RequestBody ProductDto dto) {
		return service.create(dto);
	}
	
	@PutMapping
	public ProductDto updateProduct(@RequestBody ProductDto dto) {
		return service.update(dto);
	}
	
	@DeleteMapping("/{productName}")
	public String deleteProduct(@PathVariable String productName) {
		return service.delete(productName);
	}
}
