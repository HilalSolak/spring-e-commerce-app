package com.hilalsolak.ecommercespring.api;

import com.hilalsolak.ecommercespring.dto.requests.PaymentRequest;
import com.hilalsolak.ecommercespring.dto.responses.PaymentResponse;
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
    List<PaymentResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PaymentResponse getById(@PathVariable UUID id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PaymentResponse create(@RequestBody PaymentRequest request){
        return service.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    PaymentResponse updateById(@PathVariable UUID id, @RequestBody PaymentRequest request){
        return service.updateById(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id){
        service.deleteById(id);
    }

}
