package com.hilalsolak.ecommercespring.service;

import com.hilalsolak.ecommercespring.model.dto.requests.PaymentRequest;
import com.hilalsolak.ecommercespring.model.dto.responses.PaymentResponse;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface PaymentService {
    List<PaymentResponse> getAllPayments();

    PaymentResponse getPaymentById(UUID id);

    PaymentResponse createPayment(PaymentRequest request);

    PaymentResponse updatePaymentById(UUID id, PaymentRequest request);
    void paymentProcess(PaymentRequest request, BigDecimal totalPrice);
    void deletePaymentById(UUID id);
}
