package com.hilalsolak.ecommercespring.model.dto.requests;

import java.math.BigDecimal;

public record PaymentRequest( String cardHolder,String cardNumber,int cardExpiredMonth,
                              int cardExpiredYear,int cardCvv,BigDecimal balance) {

}
