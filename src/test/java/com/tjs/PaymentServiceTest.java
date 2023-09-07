package com.tjs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.tjs.entity.Payment;
import com.tjs.repository.PaymentRepository;
import com.tjs.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    public void testMakePayment() {
        // Create a sample Payment object
        Payment payment = new Payment(1L, BigDecimal.valueOf(100.0), "Credit Card", "Pending");

        // Mock the behavior of the paymentRepository
        when(paymentRepository.save(payment)).thenReturn(payment);

        // Call the service method to make a payment
        Payment savedPayment = paymentService.makePayment(payment);

        // Verify that the payment date is set to the current date
        assertEquals(LocalDate.now(), savedPayment.getPaymentDate());

        // Verify that the payment status is set to "Pending" (or adjust based on your logic)
        assertEquals("Pending", savedPayment.getPaymentStatus());

        // Verify that the payment record is saved
        verify(paymentRepository, times(1)).save(payment);
    }
}
