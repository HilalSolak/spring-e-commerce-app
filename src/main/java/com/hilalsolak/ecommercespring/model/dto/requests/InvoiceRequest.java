package com.hilalsolak.ecommercespring.model.dto.requests;

import java.util.UUID;

public record InvoiceRequest(UUID saleId, String description) {

}
