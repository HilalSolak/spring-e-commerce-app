package com.hilalsolak.ecommercespring.api;

import com.hilalsolak.ecommercespring.dto.requests.ProductRequest;
import com.hilalsolak.ecommercespring.dto.responses.ProductResponse;
import com.hilalsolak.ecommercespring.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ProductResponse> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)

    ProductResponse getById(@PathVariable UUID id){
        return service.getById(id);
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)

    ProductResponse create(@RequestBody ProductRequest request){
        return service.create(request);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)

    ProductResponse updateById(@PathVariable UUID id,@RequestBody ProductRequest request){
        return service.updateById(id,request);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id){
        service.deleteById(id);
    }
}
