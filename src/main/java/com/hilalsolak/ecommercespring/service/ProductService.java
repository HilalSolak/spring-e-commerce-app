package com.hilalsolak.ecommercespring.service;

import com.hilalsolak.ecommercespring.dto.requests.ProductRequest;
import com.hilalsolak.ecommercespring.dto.responses.ProductResponse;
import com.hilalsolak.ecommercespring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductService  {
    List<ProductResponse> getAll();

    ProductResponse getById(UUID id);

    ProductResponse create(ProductRequest request);

    ProductResponse updateById(UUID id, ProductRequest request);
    void  deleteById(UUID id);
}
