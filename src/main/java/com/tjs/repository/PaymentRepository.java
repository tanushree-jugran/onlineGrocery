package com.tjs.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.tjs.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
   
    
    // Add more custom query methods as needed
}
