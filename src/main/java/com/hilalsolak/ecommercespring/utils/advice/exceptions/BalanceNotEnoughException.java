package com.hilalsolak.ecommercespring.utils.advice.exceptions;

public class BalanceNotEnoughException extends RuntimeException {
    public BalanceNotEnoughException(String message){
        super(message);
    }
}
