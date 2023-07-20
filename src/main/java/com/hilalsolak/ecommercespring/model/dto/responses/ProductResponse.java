package com.hilalsolak.ecommercespring.model.dto.responses;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponse(UUID id,
                              String name,
                              String description,
                              BigDecimal price,
                              int quantity,
                              CategoryResponse category) {


}
