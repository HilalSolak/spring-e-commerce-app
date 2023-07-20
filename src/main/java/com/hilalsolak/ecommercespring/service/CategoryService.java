package com.hilalsolak.ecommercespring.service;

import com.hilalsolak.ecommercespring.model.dto.requests.CategoryRequest;
import com.hilalsolak.ecommercespring.model.dto.responses.CategoryResponse;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();
    CategoryResponse getCategoryById(UUID id);
    CategoryResponse createCategory(CategoryRequest request);
    CategoryResponse updateCategoryById(UUID id, CategoryRequest request);
    List<CategoryResponse> getCategoriesBySearchText(@RequestParam String filter);
    void deleteCategoryById(UUID id);
}
