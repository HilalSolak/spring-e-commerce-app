package com.hilalsolak.ecommercespring.dto.responses;

import com.hilalsolak.ecommercespring.model.Category;

import java.util.UUID;

public record CategoryResponse(UUID id, String name) {

    public static CategoryResponse convert(Category from){
        return new CategoryResponse(from.getId(), from.getName());
    }
}
