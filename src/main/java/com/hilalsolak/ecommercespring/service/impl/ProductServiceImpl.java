package com.hilalsolak.ecommercespring.service.impl;

import com.hilalsolak.ecommercespring.dto.requests.ProductRequest;
import com.hilalsolak.ecommercespring.dto.responses.CategoryResponse;
import com.hilalsolak.ecommercespring.dto.responses.ProductResponse;
import com.hilalsolak.ecommercespring.model.Category;
import com.hilalsolak.ecommercespring.model.Product;
import com.hilalsolak.ecommercespring.repository.ProductRepository;
import com.hilalsolak.ecommercespring.service.CategoryService;
import com.hilalsolak.ecommercespring.service.ProductService;

import java.util.List;
import java.util.UUID;

public class ProductServiceImpl implements ProductService {

    private final CategoryService categoryService;
    private final ProductRepository repository;

    public ProductServiceImpl(CategoryService categoryService, ProductRepository repository) {
        this.categoryService = categoryService;
        this.repository = repository;
    }

    @Override
    public List<ProductResponse> getAll() {
        List<ProductResponse> response = repository.findAll().stream().map(ProductResponse::convert).toList();

        return response;
    }

    @Override
    public ProductResponse getById(UUID id) {
        Product product = getProductById(id);
        ProductResponse response = ProductResponse.convert(product);

        return response;
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        CategoryResponse categoryResponse = categoryService.getById(request.categoryId());
        Category category = new Category();
        category.setId(categoryResponse.id());

        Product product = new Product();

        fillProductFeatures(request,category,product);

        ProductResponse response = ProductResponse.convert(repository.save(product));

        return response;
    }

    @Override
    public ProductResponse updateById(UUID id, ProductRequest request) {
        Product product = getProductById(id);

        CategoryResponse categoryResponse = categoryService.getById(request.categoryId());
        Category category = new Category();
        category.setId(categoryResponse.id());

        fillProductFeatures(request,category,product);

        ProductResponse response = ProductResponse.convert(repository.save(product));

        return response;
    }

    @Override
    public void deleteById(UUID id) {
        Product product = getProductById(id);

        repository.delete(product);
    }
    private Product getProductById(UUID id){

        return repository.findById(id).orElseThrow(()->new RuntimeException("Product not exists"));
    }
    private void fillProductFeatures(ProductRequest request,Category category, Product product){
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setQuantity(request.quantity());
        product.setCategory(category);
    }
}
