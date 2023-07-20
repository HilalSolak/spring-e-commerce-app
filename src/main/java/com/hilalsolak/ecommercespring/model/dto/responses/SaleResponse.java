package com.hilalsolak.ecommercespring.model.dto.responses;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record SaleResponse(UUID id, String description, BigDecimal totalPrice,
                           List<ProductResponse> product) {

}
