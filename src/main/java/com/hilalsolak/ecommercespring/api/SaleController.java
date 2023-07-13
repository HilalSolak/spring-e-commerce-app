package com.hilalsolak.ecommercespring.api;

import com.hilalsolak.ecommercespring.dto.requests.SaleRequest;
import com.hilalsolak.ecommercespring.dto.responses.SaleResponse;
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
    List<SaleResponse> getAll(){
        return service.getAllSales();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    SaleResponse getById(@PathVariable UUID id){
        return service.getSaleById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    SaleResponse create(@RequestBody SaleRequest request){
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
