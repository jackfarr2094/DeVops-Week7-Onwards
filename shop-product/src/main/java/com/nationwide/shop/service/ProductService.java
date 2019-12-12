package com.nationwide.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nationwide.shop.persistence.domain.Product;
import com.nationwide.shop.persistence.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> showProducts() {
		return repository.findAll();
	}
	
	public Product updateProduct(Product product) {
		Product databaseItem = repository.findByName(product.getName());
		databaseItem.setId(product.getId());
		repository.flush();
		return databaseItem;
	}
	
	public String deleteProduct(String name) {
		Product databaseItem = repository.findByName(name);
		repository.delete(databaseItem);
		return "Deleted";
	}
}
