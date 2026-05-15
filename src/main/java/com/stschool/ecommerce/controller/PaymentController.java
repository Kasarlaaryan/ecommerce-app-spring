package com.stschool.ecommerce.controller;

import com.stschool.ecommerce.entity.Payment;
import com.stschool.ecommerce.exceptions.PaymentAlreadyExistsException;
import com.stschool.ecommerce.exceptions.PaymentNotFoundException;
import com.stschool.ecommerce.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")

public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Save Payment
    @PostMapping
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment)
            throws PaymentAlreadyExistsException {

        Payment savedPayment = paymentService.savePayment(payment);

        return ResponseEntity.ok(savedPayment);
    }

    // Get All Payments
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {

        List<Payment> payments = paymentService.getAllPayments();

        return ResponseEntity.ok(payments);
    }

    // Get Payment By Id
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable int id)
            throws PaymentNotFoundException {

        Payment payment = paymentService.getPaymentById(id)
                .orElseThrow(() ->
                        new PaymentNotFoundException(
                                "Payment not found with id : " + id
                        )
                );

        return ResponseEntity.ok(payment);
    }

    // Update Payment
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(
            @PathVariable int id,
            @RequestBody Payment payment)
            throws PaymentNotFoundException {

        Payment updatedPayment = paymentService.updatePayment(id, payment);

        return ResponseEntity.ok(updatedPayment);
    }

    // Delete Payment
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable int id)
            throws PaymentNotFoundException {

        paymentService.deletePayment(id);

        return ResponseEntity.ok("Payment deleted successfully");
    }
}
