package com.hilalsolak.ecommercespring.service;

import com.hilalsolak.ecommercespring.dto.requests.PaymentRequest;
import com.hilalsolak.ecommercespring.dto.responses.PaymentResponse;
import com.hilalsolak.ecommercespring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PaymentService {
    List<PaymentResponse> getAll();

    PaymentResponse getById(UUID id);

    PaymentResponse create(PaymentRequest request);

    PaymentResponse updateById(UUID id, PaymentRequest request);
    void  deleteById(UUID id);
}
