package com.stschool.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class OrderDto {
    private Integer id;
    private String orderId;
    private LocalDate orderedDate;
    private double totalAmount;
    private int totalItems;
    private String orderStatus;
    private LocalDate expectedDeliveryDate;
}
