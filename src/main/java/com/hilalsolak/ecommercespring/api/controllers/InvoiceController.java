package com.hilalsolak.ecommercespring.api.controllers;

import com.hilalsolak.ecommercespring.model.dto.requests.InvoiceRequest;
import com.hilalsolak.ecommercespring.model.dto.responses.InvoiceResponse;
import com.hilalsolak.ecommercespring.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    private final InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<InvoiceResponse> getAllInvoices() {
        return service.getAllInvoices();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    InvoiceResponse getInvoiceById(@PathVariable UUID id){
        return service.getInvoiceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    InvoiceResponse createInvoice(@RequestBody InvoiceRequest request){
        return service.createInvoice(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    InvoiceResponse updateInvoiceById(@PathVariable UUID id, @RequestBody InvoiceRequest request){
        return service.updateInvoiceById(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteInvoiceById(@PathVariable UUID id){
        service.deleteInvoiceById(id);
    }
}
