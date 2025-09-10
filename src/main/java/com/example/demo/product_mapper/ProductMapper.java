package com.example.demo.product_mapper;


import org.springframework.stereotype.Component;

import com.example.demo.product_Dto.ProductDto;
import com.example.demo.product_entity.ProductEntity;

@Component
public class ProductMapper {

	
    public ProductDto toDto(ProductEntity entity) { //entity to dto
        return ProductDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .category(entity.getCategory())
                .price(entity.getPrice())
                .stock(entity.getStock())
                .customerId(entity.getCustomerId())
                .vehicleId(entity.getVehicleId())
                .weight(entity.getWeight())
                
                .build();
    }

    public ProductEntity toEntity(ProductDto dto) {
        return ProductEntity.builder()
                .name(dto.getName())
                .category(dto.getCategory())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .customerId(dto.getCustomerId())
                .vehicleId(dto.getVehicleId())
                .weight(dto.getWeight())
                .build();
    }

}


