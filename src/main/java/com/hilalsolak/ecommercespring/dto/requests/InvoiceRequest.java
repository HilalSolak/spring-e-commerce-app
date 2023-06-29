package com.hilalsolak.ecommercespring.dto.requests;

import com.hilalsolak.ecommercespring.model.Sale;
import jakarta.persistence.OneToOne;

import java.util.UUID;

public record InvoiceRequest(UUID saleId, String description) {

}
