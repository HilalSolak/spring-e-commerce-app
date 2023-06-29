package com.hilalsolak.ecommercespring.dto.responses;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentResponse(UUID id, String name, String cardHolder,
                              String cardNumber,
                              int cardExpiredMonth,
                              int cardExpiredYear,
                              int cardCvv,
                              BigDecimal balance) {

}
