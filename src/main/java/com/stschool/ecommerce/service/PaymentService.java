package com.stschool.ecommerce.service;

import com.stschool.ecommerce.entity.Payment;
import com.stschool.ecommerce.exceptions.PaymentAlreadyExistsException;
import com.stschool.ecommerce.exceptions.PaymentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    // Save Payment
    Payment savePayment(Payment payment)
            throws PaymentAlreadyExistsException;

    // Get All Payments
    List<Payment> getAllPayments();

    // Get Payment By Id
    Optional<Payment> getPaymentById(int id)
            throws PaymentNotFoundException;

    // Update Payment
    Payment updatePayment(int id, Payment payment)
            throws PaymentNotFoundException;

    // Delete Payment
    void deletePayment(int id)
            throws PaymentNotFoundException;
}
