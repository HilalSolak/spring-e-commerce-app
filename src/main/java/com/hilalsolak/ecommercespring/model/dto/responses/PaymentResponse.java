package com.hilalsolak.ecommercespring.model.dto.responses;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentResponse(UUID id,String cardHolder,
                              String cardNumber,
                              int cardExpiredMonth,
                              int cardExpiredYear,
                              int cardCvv,
                              BigDecimal balance) {


}
