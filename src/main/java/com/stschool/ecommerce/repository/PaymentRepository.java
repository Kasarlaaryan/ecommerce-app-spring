package com.stschool.ecommerce.repository;

import com.stschool.ecommerce.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    // Find By Id
    Optional<Payment> findById(int id);

    // Find By Payment Mode Name
    Optional<Payment> findByPaymentMode(String paymentMode);

    // Count Total Payments
    long count();
}
