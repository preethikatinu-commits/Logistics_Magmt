package com.example.demo.product_controll;


 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.product_Dto.ProductDto;
import com.example.demo.product_service.ProductService;

	@RestController
	@RequestMapping("/api/products")
	public class ProductController {

	    @Autowired
	    private ProductService service;

	    @PostMapping("/create")
	    public ProductDto create(@RequestBody ProductDto dto) {
	     return service.createProduct(dto);
	    }

	    @GetMapping("/{id}")
	    public ProductDto getById(@PathVariable Long id) {
	        return service.getProductById(id);
	    }

	    @GetMapping
	    public List<ProductDto> getAll() {
	        return service.getAllProducts();
	    }
	    

	    @PutMapping("/{id}")
	    public void update(@PathVariable Long id, @RequestBody ProductDto dto) {
	         service.updateProduct(id, dto);
	    }

	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	        service.deleteProduct(id);
	    }
	}


