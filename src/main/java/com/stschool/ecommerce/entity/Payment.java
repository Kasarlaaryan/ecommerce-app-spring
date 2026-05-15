package com.stschool.ecommerce.entity;

import com.stschool.ecommerce.enums.PaymentMode;
import com.stschool.ecommerce.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table (name = "payments")

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long transactionId;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentMadeOn;

}
