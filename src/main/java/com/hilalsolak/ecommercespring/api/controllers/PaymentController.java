package com.hilalsolak.ecommercespring.api.controllers;

import com.hilalsolak.ecommercespring.model.dto.requests.PaymentRequest;
import com.hilalsolak.ecommercespring.model.dto.responses.PaymentResponse;
import com.hilalsolak.ecommercespring.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<PaymentResponse> getAllPayments(){
        return service.getAllPayments();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PaymentResponse getPaymentById(@PathVariable UUID id){
        return service.getPaymentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PaymentResponse createPayment(@RequestBody PaymentRequest request){
        return service.createPayment(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    PaymentResponse updatePaymentById(@PathVariable UUID id, @RequestBody PaymentRequest request){
        return service.updatePaymentById(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePaymentById(@PathVariable UUID id){
        service.deletePaymentById(id);
    }

}
