package com.hilalsolak.ecommercespring.repository;

import com.hilalsolak.ecommercespring.model.Category;
import com.hilalsolak.ecommercespring.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {

    boolean existsByCardNumber(String cardNumber);
}
