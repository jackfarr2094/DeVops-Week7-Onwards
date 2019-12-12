package com.nationwide.shop.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nationwide.shop.dto.ProductDto;

@FeignClient("product")
public interface ProductInteraction {

	@RequestMapping(value = "/product", method = {RequestMethod.GET})
	public List<ProductDto> getAll();
	
	@RequestMapping(value = "/product", method = {RequestMethod.POST})
	public ProductDto createProduct(@RequestBody ProductDto dto);
	
	@RequestMapping(value = "/product", method = {RequestMethod.PUT})
	public ProductDto updateProduct(@RequestBody ProductDto dto);
	
	@RequestMapping(value = "/product/{productName}", method = {RequestMethod.DELETE})
	public String deleteProduct(@PathVariable String productName);
}
