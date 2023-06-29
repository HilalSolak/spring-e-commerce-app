package com.hilalsolak.ecommercespring.dto.responses;

import com.hilalsolak.ecommercespring.model.Product;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponse(UUID id,
                              String name,
                              String description,
                              BigDecimal price,
                              int quantity,
                              CategoryResponse category) {
    public static ProductResponse convert(Product from){
        return new ProductResponse(from.getId(),
                from.getName(),
                from.getDescription(),
                from.getPrice(),
                from.getQuantity(),
                CategoryResponse.convert(from.getCategory()));
    }

}
