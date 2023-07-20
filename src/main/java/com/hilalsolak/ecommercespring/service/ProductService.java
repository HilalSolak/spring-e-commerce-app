package com.hilalsolak.ecommercespring.service;

import com.hilalsolak.ecommercespring.model.dto.requests.ProductRequest;
import com.hilalsolak.ecommercespring.model.dto.responses.ProductResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService  {
    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(UUID id);

    ProductResponse createProduct(ProductRequest request);

    ProductResponse updateProductById(UUID id, ProductRequest request);
    void deleteProductById(UUID id);
}
