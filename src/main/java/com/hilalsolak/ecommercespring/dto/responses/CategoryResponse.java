package com.hilalsolak.ecommercespring.dto.responses;

import com.hilalsolak.ecommercespring.model.Category;

import java.util.List;
import java.util.UUID;

public record CategoryResponse(UUID id, String name, List<CategoryProductResponse> categoryProductResponse) {


    public static CategoryResponse convert(Category from){
        return new CategoryResponse(from.getId(), from.getName(),
                from.getProducts().stream().map(CategoryProductResponse::convert).toList());

    }
}
