package com.hilalsolak.ecommercespring.dto.responses;

import com.hilalsolak.ecommercespring.model.Product;
import com.hilalsolak.ecommercespring.model.Sale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record SaleResponse(UUID id, String description, BigDecimal totalPrice,
                           List<ProductResponse> product) {

    public static SaleResponse convert(Sale from) {
        List<ProductResponse> response = from.getProducts().stream().map(ProductResponse::convert).toList();
        return new SaleResponse(from.getId(),from.getDescription(),from.getTotalPrice(),response);
    }
}
