package com.hilalsolak.ecommercespring.repository;

import com.hilalsolak.ecommercespring.model.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {

    boolean existsByCardNumber(String cardNumber);
    Optional<Payment> findByCardHolderAndCardNumberAndCardExpiredMonthAndCardExpiredYearAndCardCvv(String cardHolder,
                                                                                          String cardNumber,
                                                                                          int cardExpiredMonth,
                                                                                          int cardExpiredYear,
                                                                                          int cardCvv);
}
