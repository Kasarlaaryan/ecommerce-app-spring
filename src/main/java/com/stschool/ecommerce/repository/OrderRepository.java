package com.stschool.ecommerce.repository;

import com.stschool.ecommerce.entity.Order;
import com.stschool.ecommerce.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    // Find Order By Id
    Optional<Order> findById(int id);

    // Find Order By Payment
    Optional<Order> findByPayment(Payment payment);

    // Count Total Orders
    long count();
}
