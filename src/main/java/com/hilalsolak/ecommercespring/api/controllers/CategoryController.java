package com.hilalsolak.ecommercespring.api.controllers;

import com.hilalsolak.ecommercespring.model.dto.requests.CategoryRequest;
import com.hilalsolak.ecommercespring.model.dto.responses.CategoryResponse;
import com.hilalsolak.ecommercespring.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> getAllCategories(){
        return service.getAllCategories();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse getCategoryById(@PathVariable UUID id){
        return service.getCategoryById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse createCategory(@RequestBody CategoryRequest request){
        return service.createCategory(request);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CategoryResponse updateCategoryById(@PathVariable UUID id, @RequestBody CategoryRequest request){
        return service.updateCategoryById(id,request);
    }
    @GetMapping("/filter")
    public List<CategoryResponse> getCategoriesBySearchText(@RequestParam("filter") String filter){
        return service.getCategoriesBySearchText(filter);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategoryById(@PathVariable UUID id){
        service.deleteCategoryById(id);
    }
}
