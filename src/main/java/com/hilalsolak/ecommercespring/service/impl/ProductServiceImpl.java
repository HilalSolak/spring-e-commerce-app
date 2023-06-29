package com.hilalsolak.ecommercespring.service.impl;

import com.hilalsolak.ecommercespring.dto.requests.ProductRequest;
import com.hilalsolak.ecommercespring.dto.responses.ProductResponse;
import com.hilalsolak.ecommercespring.service.ProductService;

import java.util.List;
import java.util.UUID;

public class ProductServiceImpl implements ProductService {

    @Override
    public List<ProductResponse> getAll() {
        return null;
    }

    @Override
    public ProductResponse getById(UUID id) {
        return null;
    }

    @Override
    public ProductResponse createById(ProductRequest request) {
        return null;
    }

    @Override
    public ProductResponse updateById(UUID id, ProductRequest request) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
