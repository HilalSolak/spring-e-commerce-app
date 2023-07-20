package com.hilalsolak.ecommercespring.service;

import com.hilalsolak.ecommercespring.model.dto.requests.InvoiceRequest;
import com.hilalsolak.ecommercespring.model.dto.responses.InvoiceResponse;

import java.util.List;
import java.util.UUID;

public interface InvoiceService {
    List<InvoiceResponse> getAllInvoices();

    InvoiceResponse getInvoiceById(UUID id);

    InvoiceResponse createInvoice(InvoiceRequest request);

    InvoiceResponse updateInvoiceById(UUID id, InvoiceRequest request);
    void deleteInvoiceById(UUID id);
}
