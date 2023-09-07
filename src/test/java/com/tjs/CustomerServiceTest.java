package com.tjs;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.tjs.entity.Customer;
import com.tjs.repository.CustomerRepository;
import com.tjs.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CustomerServiceTest {


    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void testGetAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John", "john@example.com", "1234567890", "123 Main St", "password"));
        customers.add(new Customer("Jane", "jane@example.com", "9876543210", "456 Elm St", "password"));

        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> result = customerService.getAllCustomers();

        assertEquals(customers, result);
    }

    @Test
    public void testGetCustomerById() {
        Customer sampleCustomer = new Customer("John", "john@example.com", "1234567890", "123 Main St", "password");
        sampleCustomer.setCustomerId(1L);

        when(customerRepository.findById(1L)).thenReturn(Optional.of(sampleCustomer));

        Optional<Customer> result = customerService.getCustomerById(1L);

        assertTrue(result.isPresent());
        assertEquals(sampleCustomer, result.get());
    }

    @Test
    public void testCreateCustomer() {
        Customer sampleCustomer = new Customer("John", "john@example.com", "1234567890", "123 Main St", "password");
        sampleCustomer.setCustomerId(1L);

        when(customerRepository.save(sampleCustomer)).thenReturn(sampleCustomer);

        Customer result = customerService.createCustomer(sampleCustomer);

        assertEquals(sampleCustomer, result);
    }

    @Test
    public void testLoginCustomer() {
        Customer sampleCustomer = new Customer("John", "john@example.com", "1234567890", "123 Main St", "password");
        sampleCustomer.setCustomerId(1L);

        when(customerRepository.findByEmailAndPassword("john@example.com", "password")).thenReturn(Optional.of(sampleCustomer));

        Optional<Customer> result = customerService.loginCustomer("john@example.com", "password");

        assertTrue(result.isPresent());
        assertEquals(sampleCustomer, result.get());
    }

    @Test
    public void testUpdateCustomer() {
        Customer sampleCustomer = new Customer("John", "john@example.com", "1234567890", "123 Main St", "password");
        sampleCustomer.setCustomerId(1L);
        Customer updatedCustomer = new Customer("Jane", "jane@example.com", "9876543210", "456 Elm St", "newpassword");

        when(customerRepository.findById(1L)).thenReturn(Optional.of(sampleCustomer));
        when(customerRepository.save(sampleCustomer)).thenReturn(updatedCustomer);

        Customer result = customerService.updateCustomer(1L, updatedCustomer);

        assertEquals(updatedCustomer, result);
    }
}