package com.tjs.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjs.entity.Payment;
import com.tjs.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment makePayment(Payment payment) {
        // Set the payment date to the current date
        payment.setPaymentDate(LocalDate.now());

        // Set the payment status to "Pending" or process it based on your business logic
        payment.setPaymentStatus("Pending");

        // Save the payment record to the database
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        // Retrieve all payment records from the database
        return paymentRepository.findAll();
    }

}
