package com.hilalsolak.ecommercespring.api;

import com.hilalsolak.ecommercespring.dto.requests.InvoiceRequest;
import com.hilalsolak.ecommercespring.dto.responses.InvoiceResponse;
import com.hilalsolak.ecommercespring.model.Invoice;
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
    List<InvoiceResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    InvoiceResponse getById(@PathVariable UUID id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    InvoiceResponse create(@RequestBody InvoiceRequest request){
        return service.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    InvoiceResponse update(@PathVariable UUID id, @RequestBody InvoiceRequest request){
        return service.updateById(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteById(@PathVariable UUID id){
        service.deleteById(id);
    }
}
