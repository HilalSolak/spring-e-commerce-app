package com.hilalsolak.ecommercespring.service;

import com.hilalsolak.ecommercespring.dto.requests.CategoryRequest;
import com.hilalsolak.ecommercespring.dto.responses.CategoryResponse;
import com.hilalsolak.ecommercespring.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<CategoryResponse> getAll();
    CategoryResponse getById(UUID id);
    CategoryResponse createById(CategoryRequest request);
    CategoryResponse updateById(UUID id, CategoryRequest request);
    void deleteById(UUID id);
}
