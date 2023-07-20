package com.hilalsolak.ecommercespring.model.dto.requests;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductRequest(UUID categoryId, String name, String description, BigDecimal price, int quantity) {

}
