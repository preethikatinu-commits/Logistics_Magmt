package com.example.demo.product_service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.product_Dto.ProductDto;
import com.example.demo.product_entity.ProductEntity;
import com.example.demo.product_exception.ResourceNotFoundException;
import com.example.demo.product_mapper.ProductMapper;
import com.example.demo.product_repository.ProductRepository;

	@Service
	public class ProductServiceImple implements ProductService {

	    @Autowired
	    private ProductRepository repository;

	    @Autowired
	    private ProductMapper mapper;

	   // @Override
	    public ProductDto createProduct(ProductDto dto) {
	        ProductEntity saved = repository.save(mapper.toEntity(dto));
	        //System.out.println(saved);
	        return mapper.toDto(saved);
	    }

	    @Override
	    public ProductDto getProductById(Long id) {
	        ProductEntity entity = repository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Product", "ID", id));
	        return mapper.toDto(entity);
	    }

	    @Override
	    public List<ProductDto> getAllProducts() {
	        return repository.findAll().stream()
	                .map(mapper::toDto)
	                .collect(Collectors.toList());
	    }

	    @Override
	    public ProductDto updateProduct(Long id, ProductDto dto) {
	        ProductEntity entity = repository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Product", "ID", id));

	        entity.setName(dto.getName());
	        entity.setCategory(dto.getCategory());
	        entity.setPrice(dto.getPrice());
	        entity.setStock(dto.getStock());
	        entity.setCustomerId(dto.getCustomerId());
	        entity.setVehicleId(dto.getVehicleId());
	        entity.setWeight(dto.getWeight());

	        return mapper.toDto(repository.save(entity));
	    }

	    @Override
	    public void deleteProduct(Long id) {
	        ProductEntity entity = repository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Product", "ID", id));
	        repository.delete(entity);
	    }
	}


