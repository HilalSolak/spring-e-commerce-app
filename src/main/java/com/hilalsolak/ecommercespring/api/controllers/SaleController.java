package com.hilalsolak.ecommercespring.api.controllers;

import com.hilalsolak.ecommercespring.model.dto.requests.SaleRequest;
import com.hilalsolak.ecommercespring.model.dto.responses.SaleResponse;
import com.hilalsolak.ecommercespring.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sales")
public class SaleController {
    private final SaleService service;

    public SaleController(SaleService service) {
        this.service = service;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<SaleResponse> getAllSales(){
        return service.getAllSales();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    SaleResponse getSaleById(@PathVariable UUID id){
        return service.getSaleById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    SaleResponse createSale(@RequestBody SaleRequest request){
        return service.createSale(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    SaleResponse updateById(@PathVariable UUID id,@RequestBody SaleRequest request){
        return service.updateSaleById(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id){
        service.deleteSaleById(id);
    }
}
