package com.hilalsolak.ecommercespring.service.impl;

import com.hilalsolak.ecommercespring.dto.requests.CategoryRequest;
import com.hilalsolak.ecommercespring.dto.responses.CategoryResponse;
import com.hilalsolak.ecommercespring.service.CategoryService;

import java.util.List;
import java.util.UUID;

public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<CategoryResponse> getAll() {
        return null;
    }

    @Override
    public CategoryResponse getById(UUID id) {
        return null;
    }

    @Override
    public CategoryResponse createById(CategoryRequest request) {
        return null;
    }

    @Override
    public CategoryResponse updateById(UUID id, CategoryRequest request) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
