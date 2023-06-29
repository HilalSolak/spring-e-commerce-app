package com.hilalsolak.ecommercespring.service.impl;

import com.hilalsolak.ecommercespring.dto.requests.SaleRequest;
import com.hilalsolak.ecommercespring.dto.responses.SaleResponse;
import com.hilalsolak.ecommercespring.service.SaleService;

import java.util.List;
import java.util.UUID;

public class SaleServiceImpl implements SaleService {

    @Override
    public List<SaleResponse> getAll() {
        return null;
    }

    @Override
    public SaleResponse getById(UUID id) {
        return null;
    }

    @Override
    public SaleResponse createById(SaleRequest request) {
        return null;
    }

    @Override
    public SaleResponse updateById(UUID id, SaleRequest request) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
