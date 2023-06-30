package com.hilalsolak.ecommercespring.service.impl;

import com.hilalsolak.ecommercespring.constants.GlobalConstants;
import com.hilalsolak.ecommercespring.dto.requests.InvoiceRequest;
import com.hilalsolak.ecommercespring.dto.responses.InvoiceResponse;
import com.hilalsolak.ecommercespring.exception.EntityAlreadyExistsException;
import com.hilalsolak.ecommercespring.exception.EntityNotFoundException;
import com.hilalsolak.ecommercespring.model.Invoice;
import com.hilalsolak.ecommercespring.model.Sale;
import com.hilalsolak.ecommercespring.repository.InvoiceRepository;
import com.hilalsolak.ecommercespring.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository repository;

    public InvoiceServiceImpl(InvoiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<InvoiceResponse> getAll() {
        List<InvoiceResponse> response = repository.findAll().stream().map(InvoiceResponse::convert).toList();

        return response;
    }

    @Override
    public InvoiceResponse getById(UUID id) {
        Invoice invoice = getInvoiceById(id);
        InvoiceResponse response = InvoiceResponse.convert(invoice);
        return response;
    }
    @Override
    public InvoiceResponse create(InvoiceRequest request) {
        checkIfInvoiceAlreadyExists(request);
        Invoice invoice = new Invoice();
        fillInvoiceFeatures(invoice,request);
        InvoiceResponse response = InvoiceResponse.convert(repository.save(invoice));

        return response;
    }


    @Override
    public InvoiceResponse updateById(UUID id, InvoiceRequest request) {
        Invoice invoice = getInvoiceById(id);
        fillInvoiceFeatures(invoice,request);
        InvoiceResponse response = InvoiceResponse.convert(repository.save(invoice));

        return response;
    }

    @Override
    public void deleteById(UUID id) {
        Invoice invoice = getInvoiceById(id);
        repository.delete(invoice);
    }
    private Invoice getInvoiceById(UUID id) {
        return repository.findById(id).orElseThrow(()-> new EntityNotFoundException(GlobalConstants.INVOICE_NOT_FOUND));
    }
    private void checkIfInvoiceAlreadyExists(InvoiceRequest request) {
        if(repository.existsById(request.saleId())){
            throw new EntityAlreadyExistsException(GlobalConstants.INVOICE_ALREADY_EXISTS);
        }
    }
    private void fillInvoiceFeatures(Invoice invoice, InvoiceRequest request) {
        Sale sale = new Sale();
        sale.setId(request.saleId());
        invoice.setDescription(request.description());
        invoice.setSale(sale);
    }
}
