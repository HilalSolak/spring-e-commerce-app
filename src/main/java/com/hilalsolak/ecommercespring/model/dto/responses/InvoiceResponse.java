package com.hilalsolak.ecommercespring.model.dto.responses;

import java.util.UUID;

public record InvoiceResponse(UUID id,UUID saleId,String decription) {


}
