package com.hilalsolak.ecommercespring.dto.responses;

import com.hilalsolak.ecommercespring.model.Payment;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentResponse(UUID id,String cardHolder,
                              String cardNumber,
                              int cardExpiredMonth,
                              int cardExpiredYear,
                              int cardCvv,
                              BigDecimal balance) {
    public static PaymentResponse convert(Payment from){
        return new PaymentResponse(from.getId(),
                from.getCardHolder(),
                from.getCardNumber(),
                from.getCardExpiredMonth(),
                from.getCardExpiredYear(),
                from.getCardCvv(),
                from.getBalance());
    }

}
