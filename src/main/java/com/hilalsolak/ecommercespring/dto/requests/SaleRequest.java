package com.hilalsolak.ecommercespring.dto.requests;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record SaleRequest(String description, BigDecimal totalPrice, List<UUID> products, PaymentRequest paymentRequest) {

}
