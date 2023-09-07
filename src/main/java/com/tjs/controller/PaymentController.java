package com.tjs.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tjs.entity.Payment;
import com.tjs.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> makePayment(@RequestBody Payment payment) {
        Payment savedPayment = paymentService.makePayment(payment);
        return ResponseEntity.ok(savedPayment);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> allPayments = paymentService.getAllPayments();
        if (allPayments.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(allPayments);
        }
    }
}
