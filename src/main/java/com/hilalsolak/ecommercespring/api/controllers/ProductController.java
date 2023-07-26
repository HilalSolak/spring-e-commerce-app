package com.hilalsolak.ecommercespring.api.controllers;

import com.hilalsolak.ecommercespring.model.dto.requests.ProductRequest;
import com.hilalsolak.ecommercespring.model.dto.responses.ProductResponse;
import com.hilalsolak.ecommercespring.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ProductResponse> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ProductResponse getProductById(@PathVariable UUID id){
        return service.getProductById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    ProductResponse createProduct(@RequestBody ProductRequest request){
        return service.createProduct(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    ProductResponse updateProductById(@PathVariable UUID id,@RequestBody ProductRequest request){
        return service.updateProductById(id,request);
    }
    @PutMapping("/increase/{productName}")
    @ResponseStatus(HttpStatus.OK)
    public void increaseProductSearchCount(@PathVariable String productName){
        service.increaseProductSearchCount(productName);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable UUID id){
        service.deleteProductById(id);
    }
}
