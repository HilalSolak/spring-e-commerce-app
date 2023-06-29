package com.hilalsolak.ecommercespring.service;

import com.hilalsolak.ecommercespring.dto.requests.InvoiceRequest;
import com.hilalsolak.ecommercespring.dto.responses.InvoiceResponse;
import com.hilalsolak.ecommercespring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InvoiceService {
    List<InvoiceResponse> getAll();

    InvoiceResponse getById(UUID id);

    InvoiceResponse createById(InvoiceRequest request);

    InvoiceResponse updateById(UUID id, InvoiceRequest request);
    void  deleteById(UUID id);
}
