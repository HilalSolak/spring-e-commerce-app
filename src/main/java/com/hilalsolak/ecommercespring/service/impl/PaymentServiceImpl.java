package com.hilalsolak.ecommercespring.service.impl;

import com.hilalsolak.ecommercespring.dto.requests.PaymentRequest;
import com.hilalsolak.ecommercespring.dto.responses.PaymentResponse;
import com.hilalsolak.ecommercespring.service.PaymentService;

import java.util.List;
import java.util.UUID;

public class PaymentServiceImpl implements PaymentService {

    @Override
    public List<PaymentResponse> getAll() {
        return null;
    }

    @Override
    public PaymentResponse getById(UUID id) {
        return null;
    }

    @Override
    public PaymentResponse createById(PaymentRequest request) {
        return null;
    }

    @Override
    public PaymentResponse updateById(UUID id, PaymentRequest request) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
