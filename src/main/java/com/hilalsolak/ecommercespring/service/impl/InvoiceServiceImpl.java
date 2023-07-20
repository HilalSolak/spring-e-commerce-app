package com.hilalsolak.ecommercespring.service.impl;

import com.hilalsolak.ecommercespring.converters.ConverterResponse;
import com.hilalsolak.ecommercespring.utils.advice.exceptions.EntityAlreadyExistsException;
import com.hilalsolak.ecommercespring.utils.advice.exceptions.EntityNotFoundException;
import com.hilalsolak.ecommercespring.utils.constants.GlobalConstants;
import com.hilalsolak.ecommercespring.model.dto.requests.InvoiceRequest;
import com.hilalsolak.ecommercespring.model.dto.responses.InvoiceResponse;
import com.hilalsolak.ecommercespring.model.entities.Invoice;
import com.hilalsolak.ecommercespring.model.entities.Sale;
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
    public List<InvoiceResponse> getAllInvoices() {
        List<InvoiceResponse> response = repository.findAll().stream().map(ConverterResponse::convert).toList();

        return response;
    }

    @Override
    public InvoiceResponse getInvoiceById(UUID id) {
        Invoice invoice = getInvoiceByIdInRepository(id);
        InvoiceResponse response = ConverterResponse.convert(invoice);
        return response;
    }
    @Override
    public InvoiceResponse createInvoice(InvoiceRequest request) {
        checkIfInvoiceAlreadyExists(request);
        Invoice invoice = new Invoice();
        fillInvoiceFeatures(invoice,request);
        InvoiceResponse response = ConverterResponse.convert(repository.save(invoice));

        return response;
    }


    @Override
    public InvoiceResponse updateInvoiceById(UUID id, InvoiceRequest request) {
        Invoice invoice = getInvoiceByIdInRepository(id);
        fillInvoiceFeatures(invoice,request);
        InvoiceResponse response = ConverterResponse.convert(repository.save(invoice));

        return response;
    }

    @Override
    public void deleteInvoiceById(UUID id) {
        Invoice invoice = getInvoiceByIdInRepository(id);
        repository.delete(invoice);
    }
    private Invoice getInvoiceByIdInRepository(UUID id) {
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
