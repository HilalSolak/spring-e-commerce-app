package com.hilalsolak.ecommercespring.service;

import com.hilalsolak.ecommercespring.dto.requests.SaleRequest;
import com.hilalsolak.ecommercespring.dto.responses.SaleResponse;

import java.util.List;
import java.util.UUID;

public interface SaleService {
    List<SaleResponse> getAllSales();

    SaleResponse getSaleById(UUID id);

    SaleResponse createSale(SaleRequest request);

    SaleResponse updateSaleById(UUID id, SaleRequest request);
    void deleteSaleById(UUID id);

}
