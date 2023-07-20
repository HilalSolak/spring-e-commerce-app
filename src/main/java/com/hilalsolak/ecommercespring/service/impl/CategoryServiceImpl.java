package com.hilalsolak.ecommercespring.service.impl;

import com.hilalsolak.ecommercespring.converters.ConverterResponse;
import com.hilalsolak.ecommercespring.utils.advice.exceptions.EntityAlreadyExistsException;
import com.hilalsolak.ecommercespring.utils.advice.exceptions.EntityNotFoundException;
import com.hilalsolak.ecommercespring.utils.constants.GlobalConstants;
import com.hilalsolak.ecommercespring.model.dto.requests.CategoryRequest;
import com.hilalsolak.ecommercespring.model.dto.responses.CategoryResponse;
import com.hilalsolak.ecommercespring.model.entities.Category;
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
    public List<CategoryResponse> getAllCategories() {
        List<CategoryResponse> response = repository.findAll().stream().
                map(ConverterResponse::convert)
                .toList();

        return response;
    }

    @Override
    public CategoryResponse getCategoryById(UUID id) {
        Category category = getCategoryByIdInRepository(id);
        CategoryResponse response =  ConverterResponse.convert(category);

        return response;
    }

    @Override
    public CategoryResponse createCategory(CategoryRequest request) {
        checkIfCategoryIsAlreadyExists(request.name());
        Category category =  new Category();
        category.setName(request.name());
        CategoryResponse response = ConverterResponse.convert(repository.save(category));

        return response;
    }

    @Override
    public CategoryResponse updateCategoryById(UUID id, CategoryRequest request) {
        Category category = getCategoryByIdInRepository(id);
        category.setName(request.name());
        CategoryResponse response = ConverterResponse.convert(repository.save(category));

        return response;
    }

    @Override
    public void deleteCategoryById(UUID id) {
        Category category = getCategoryByIdInRepository(id);
        repository.delete(category);

    }

    @Override
    public List<CategoryResponse> getCategoriesBySearchText(String filter) {

        List<CategoryResponse> responseList = repository.findAll().stream().filter(category -> category.getName()
                .startsWith(filter)).map(ConverterResponse::convert).toList();

        return responseList;
    }


    private Category getCategoryByIdInRepository(UUID id){
        return  repository.findById(id).orElseThrow(()->new EntityNotFoundException(GlobalConstants.CATEGORY_NOT_FOUND));
    }
    private void checkIfCategoryIsAlreadyExists(String name){
        if (repository.existsByName(name)){
            throw new EntityAlreadyExistsException(GlobalConstants.CATEGORY_ALREADY_EXISTS);
        }
    }
}
