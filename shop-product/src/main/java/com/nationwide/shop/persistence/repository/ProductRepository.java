package com.nationwide.shop.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nationwide.shop.persistence.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	public Product findByName(String name);
}
