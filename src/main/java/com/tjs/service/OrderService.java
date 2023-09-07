package com.tjs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjs.entity.Order;
import com.tjs.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        // Add any business logic related to order creation here
        // For example, you can calculate the total amount, set order status, etc.
        
        // Save the new order to the database
        return orderRepository.save(order);
    }

    // You can add more service methods for orders as needed
}
