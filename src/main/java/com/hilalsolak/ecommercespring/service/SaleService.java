package com.hilalsolak.ecommercespring.service;

import com.hilalsolak.ecommercespring.dto.requests.SaleRequest;
import com.hilalsolak.ecommercespring.dto.responses.SaleResponse;
import com.hilalsolak.ecommercespring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SaleService {
    List<SaleResponse> getAll();

    SaleResponse getById(UUID id);

    SaleResponse createById(SaleRequest request);

    SaleResponse updateById(UUID id, SaleRequest request);
    void  deleteById(UUID id);

}
