package com.stschool.ecommerce.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable

public class Address {
    private String houseNo;
    private String building;
    private String landMark;
    private String street;
    private String city;
    private String district;
    private String state;
    private String country;
    private int zipCode;

}
