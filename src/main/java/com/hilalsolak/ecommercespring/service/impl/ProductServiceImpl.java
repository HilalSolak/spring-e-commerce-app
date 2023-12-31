package com.hilalsolak.ecommercespring.service.impl;

import com.hilalsolak.ecommercespring.converters.ConverterResponse;
import com.hilalsolak.ecommercespring.utils.advice.exceptions.EntityNotFoundException;
import com.hilalsolak.ecommercespring.utils.constants.GlobalConstants;
import com.hilalsolak.ecommercespring.model.dto.requests.ProductRequest;
import com.hilalsolak.ecommercespring.model.dto.responses.CategoryResponse;
import com.hilalsolak.ecommercespring.model.dto.responses.ProductResponse;
import com.hilalsolak.ecommercespring.model.entities.Category;
import com.hilalsolak.ecommercespring.model.entities.Product;
import com.hilalsolak.ecommercespring.repository.ProductRepository;
import com.hilalsolak.ecommercespring.service.CategoryService;
import com.hilalsolak.ecommercespring.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final CategoryService categoryService;
    private final ProductRepository repository;

    public ProductServiceImpl(CategoryService categoryService, ProductRepository repository) {
        this.categoryService = categoryService;
        this.repository = repository;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> response = repository.findAll().stream()
                .map(ConverterResponse::convert)
                .toList();

        return response;
    }

    @Override
    public ProductResponse getProductById(UUID id) {
        Product product = getProductByIdInRepository(id);
            ProductResponse response = ConverterResponse.convert(product);

        return response;
    }

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        CategoryResponse categoryResponse = categoryService.getCategoryById(request.categoryId());
        Category category = new Category();
        category.setId(categoryResponse.id());
        category.setName(categoryResponse.name());

        Product product = new Product();

        fillProductFeatures(request,category,product);

        ProductResponse response = ConverterResponse.convert(repository.save(product));

        return response;
    }

    @Override
    public ProductResponse updateProductById(UUID id, ProductRequest request) {
        Product product = getProductByIdInRepository(id);

        CategoryResponse categoryResponse = categoryService.getCategoryById(request.categoryId());
        Category category = new Category();
        category.setId(categoryResponse.id());
        category.setName(categoryResponse.name());

        fillProductFeatures(request,category,product);

        ProductResponse response = ConverterResponse.convert(repository.save(product));

        return response;
    }

    @Override
    public void deleteProductById(UUID id) {
        Product product = getProductByIdInRepository(id);

        repository.delete(product);
    }

    @Override
    public void increaseProductSearchCount(String productName) {
        Product productByName = repository.findProductByName(productName);
        if(productByName.getSearchCount() == null) {
            productByName.setSearchCount(0);
        }
        Integer searchCount = productByName.getSearchCount();
        productByName.setSearchCount(++searchCount);
        repository.save(productByName);
    }

    private Product getProductByIdInRepository(UUID id){

        return repository.findById(id).orElseThrow(()->new EntityNotFoundException(GlobalConstants.PRODUCT_NOT_FOUND));
    }
    private void fillProductFeatures(ProductRequest request,Category category, Product product){
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setQuantity(request.quantity());
        product.setCategory(category);
    }
}
