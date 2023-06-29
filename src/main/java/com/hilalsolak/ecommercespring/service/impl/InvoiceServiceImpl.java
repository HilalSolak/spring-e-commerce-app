package com.hilalsolak.ecommercespring.service.impl;

import com.hilalsolak.ecommercespring.dto.requests.InvoiceRequest;
import com.hilalsolak.ecommercespring.dto.responses.InvoiceResponse;
import com.hilalsolak.ecommercespring.service.InvoiceService;

import java.util.List;
import java.util.UUID;

public class InvoiceServiceImpl implements InvoiceService {

    @Override
    public List<InvoiceResponse> getAll() {
        return null;
    }

    @Override
    public InvoiceResponse getById(UUID id) {
        return null;
    }

    @Override
    public InvoiceResponse createById(InvoiceRequest request) {
        return null;
    }

    @Override
    public InvoiceResponse updateById(UUID id, InvoiceRequest request) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
