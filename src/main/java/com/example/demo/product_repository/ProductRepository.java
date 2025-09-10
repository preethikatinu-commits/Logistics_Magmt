package com.example.demo.product_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.product_entity.ProductEntity;
@Repository
	public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	}


