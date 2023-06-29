package com.hilalsolak.ecommercespring.service.impl;

import com.hilalsolak.ecommercespring.dto.requests.CategoryRequest;
import com.hilalsolak.ecommercespring.dto.responses.CategoryResponse;
import com.hilalsolak.ecommercespring.model.Category;
import com.hilalsolak.ecommercespring.repository.CategoryRepository;
import com.hilalsolak.ecommercespring.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CategoryResponse> getAll() {
        List<CategoryResponse> response = repository.findAll().stream().
                map(CategoryResponse::convert)
                .toList();

        return response;
    }

    @Override
    public CategoryResponse getById(UUID id) {
        Category category = getCategoryById(id);
        CategoryResponse response =  CategoryResponse.convert(category);

        return response;
    }

    @Override
    public CategoryResponse create(CategoryRequest request) {
        Category category =  new Category();
        category.setName(request.name());
        CategoryResponse response = CategoryResponse.convert(repository.save(category));

        return response;
    }

    @Override
    public CategoryResponse updateById(UUID id, CategoryRequest request) {
        Category category = getCategoryById(id);
        category.setName(request.name());
        CategoryResponse response = CategoryResponse.convert(repository.save(category));

        return response;
    }

    @Override
    public void deleteById(UUID id) {
        Category category = getCategoryById(id);
        repository.delete(category);
    }
    private Category getCategoryById(UUID id){
        return  repository.findById(id).orElseThrow(()->new RuntimeException("Category not exists"));
    }
}
