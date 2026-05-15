package com.stschool.ecommerce.service;

import com.stschool.ecommerce.entity.Payment;
import com.stschool.ecommerce.exceptions.PaymentAlreadyExistsException;
import com.stschool.ecommerce.exceptions.PaymentNotFoundException;
import com.stschool.ecommerce.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Save Payment
    @Override
    public Payment savePayment(Payment payment)
            throws PaymentAlreadyExistsException {

        if (paymentRepository.existsById(payment.getId())) {
            throw new PaymentAlreadyExistsException(
                    "Payment already exists with id : " + payment.getId()
            );
        }

        return paymentRepository.save(payment);
    }

    // Get All Payments
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get Payment By Id
    @Override
    public Optional<Payment> getPaymentById(int id)
            throws PaymentNotFoundException {

        Optional<Payment> payment = paymentRepository.findById(id);

        if (payment.isEmpty()) {
            throw new PaymentNotFoundException(
                    "Payment not found with id : " + id
            );
        }

        return payment;
    }

    // Update Payment
    @Override
    public Payment updatePayment(int id, Payment payment)
            throws PaymentNotFoundException {

        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() ->
                        new PaymentNotFoundException(
                                "Payment not found with id : " + id
                        )
                );

        existingPayment.setTransactionId(payment.getTransactionId());
        existingPayment.setPaymentMode(payment.getPaymentMode());
        existingPayment.setPaymentStatus(payment.getPaymentStatus());
        existingPayment.setPaymentMadeOn(payment.getPaymentMadeOn());

        return paymentRepository.save(existingPayment);
    }

    // Delete Payment
    @Override
    public void deletePayment(int id)
            throws PaymentNotFoundException {

        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() ->
                        new PaymentNotFoundException(
                                "Payment not found with id : " + id
                        )
                );

        paymentRepository.delete(existingPayment);
    }
}
