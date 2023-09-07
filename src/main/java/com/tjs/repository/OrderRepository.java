package com.tjs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjs.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // Custom query methods
    Optional<Order> findByOrderId(Long orderId);
    List<Order> findByCustomerId(Long customerId);
}

