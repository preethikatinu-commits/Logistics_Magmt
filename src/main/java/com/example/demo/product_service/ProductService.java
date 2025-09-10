package com.example.demo.product_service;


import java.util.List;
import com.example.demo.product_Dto.ProductDto;


   public interface ProductService {

	    ProductDto createProduct(ProductDto dto);

	    ProductDto getProductById(Long id);

	    List<ProductDto> getAllProducts();

	    ProductDto updateProduct(Long id, ProductDto dto);

	    void deleteProduct(Long id);

		

}
