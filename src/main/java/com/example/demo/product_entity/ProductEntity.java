package com.example.demo.product_entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name="Products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;

private String category;
private Double price;
private Integer stock;

@Column(name = "customer_id")   // ✅ match DB
private Long customerId;

@Column(name = "vehicle_id")    // ✅ match DB
private Long vehicleId;    // Instead of full Vehicle entity
private Long weight;
// Optionally, if you want nested details instead of just IDs:
// private CustomerDTO customer;
// private VehicleDTO vehicle;

 

}