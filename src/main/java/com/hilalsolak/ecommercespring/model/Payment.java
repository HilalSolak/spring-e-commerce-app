package com.hilalsolak.ecommercespring.model;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Payment extends BaseModel{
    private String cardHolder;
    private String cardNumber;
    private int cardExpiredMonth;
    private int cardExpiredYear;
    private int cardCvv;
    private BigDecimal balance;

    public Payment() {
    }

    public Payment(String cardHolder, String cardNumber, int cardExpiredMonth, int cardExpiredYear, int cardCvv, BigDecimal balance) {
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.cardExpiredMonth = cardExpiredMonth;
        this.cardExpiredYear = cardExpiredYear;
        this.cardCvv = cardCvv;
        this.balance = balance;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardExpiredMonth() {
        return cardExpiredMonth;
    }

    public void setCardExpiredMonth(int cardExpiredMonth) {
        this.cardExpiredMonth = cardExpiredMonth;
    }

    public int getCardExpiredYear() {
        return cardExpiredYear;
    }

    public void setCardExpiredYear(int cardExpiredYear) {
        this.cardExpiredYear = cardExpiredYear;
    }

    public int getCardCvv() {
        return cardCvv;
    }

    public void setCardCvv(int cardCvv) {
        this.cardCvv = cardCvv;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
