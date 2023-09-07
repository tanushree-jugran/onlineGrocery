package com.tjs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjs.entity.Customer;
import com.tjs.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public Customer createCustomer(Customer customer) {
        // Add validation logic here if needed
        return customerRepository.save(customer);
    }

    public Optional<Customer> loginCustomer(String email, String password) {
        // Implement login logic, e.g., by checking email and password
        return customerRepository.findByEmailAndPassword(email, password);
    }

    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
        // Add validation and update logic here
        Optional<Customer> existingCustomer = customerRepository.findById(customerId);
        if (existingCustomer.isPresent()) {
            Customer customerToUpdate = existingCustomer.get();
            // Update customer fields as needed
            // Example: customerToUpdate.setName(updatedCustomer.getName());
            // Save the updated customer
            return customerRepository.save(customerToUpdate);
        }
        return null; // Customer not found
    }

    // Other service methods for additional customer operations
}
