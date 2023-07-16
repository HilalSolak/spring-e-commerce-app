package com.hilalsolak.ecommercespring.dto.responses;

import com.hilalsolak.ecommercespring.model.Product;

public record CategoryProductResponse(String productId, String productName,String description) {
    public static CategoryProductResponse convert(Product from){
        return new CategoryProductResponse(from.getId().toString(), from.getName(),from.getDescription());
    }
}
