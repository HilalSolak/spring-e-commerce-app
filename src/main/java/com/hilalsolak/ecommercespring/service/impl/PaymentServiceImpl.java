package com.hilalsolak.ecommercespring.service.impl;

import com.hilalsolak.ecommercespring.constants.GlobalConstants;
import com.hilalsolak.ecommercespring.dto.requests.PaymentRequest;
import com.hilalsolak.ecommercespring.dto.responses.CategoryResponse;
import com.hilalsolak.ecommercespring.dto.responses.PaymentResponse;
import com.hilalsolak.ecommercespring.exception.EntityAlreadyExistsException;
import com.hilalsolak.ecommercespring.exception.EntityNotFoundException;
import com.hilalsolak.ecommercespring.model.Payment;
import com.hilalsolak.ecommercespring.repository.PaymentRepository;
import com.hilalsolak.ecommercespring.service.PaymentService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository repository;


    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PaymentResponse> getAll() {
        List<PaymentResponse> response = repository.findAll().stream().map(PaymentResponse::convert).toList();
        return response;
    }

    @Override
    public PaymentResponse getById(UUID id) {
        Payment payment = getPaymentById(id);
        PaymentResponse response = PaymentResponse.convert(payment);

        return response;
    }



    @Override
    public PaymentResponse create(PaymentRequest request) {
        checkIfCardNumberExists(request);

        Payment payment = new Payment();
        fillPaymentFeatures(payment,request);
        PaymentResponse response = PaymentResponse.convert(repository.save(payment));

        return response;
    }




    @Override
    public PaymentResponse updateById(UUID id, PaymentRequest request) {
        Payment payment = getPaymentById(id);
        fillPaymentFeatures(payment,request);
        PaymentResponse response = PaymentResponse.convert(repository.save(payment));
        return response;
    }

    @Override
    public void deleteById(UUID id) {
        Payment payment = getPaymentById(id);
        repository.delete(payment);
    }
    private Payment getPaymentById(UUID id) {

        return repository.findById(id).orElseThrow(()->
                new EntityNotFoundException(GlobalConstants.PAYMENT_NOT_FOUND));
    }
    private void fillPaymentFeatures(Payment payment, PaymentRequest request) {
        payment.setCardHolder(request.cardHolder());
        payment.setCardNumber(request.cardNumber());
        payment.setCardExpiredMonth(request.cardExpiredMonth());
        payment.setCardExpiredYear(request.cardExpiredYear());
        payment.setCardCvv(request.cardCvv());
        payment.setBalance(request.balance());
    }
    private void checkIfCardNumberExists(PaymentRequest request) {
         if(repository.existsByCardNumber(request.cardNumber())){
             throw new EntityAlreadyExistsException(GlobalConstants.CARD_NUMBER_ALREADY_EXISTS);
         }
    }
}
