package com.stschool.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "products")

public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "max_Retail_price")
    private int maxRetailPrice;
    @Column(name = "discount_percentage")
    private float discountPercentage;
    private int rating;
    @Column(name = "is_available")
    private boolean isAvailable;
    private String company;
    private String category;
    @Column(name = "manufactured_year")
    private int manufacturedYear;
}
