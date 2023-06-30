package com.hilalsolak.ecommercespring.dto.responses;

import com.hilalsolak.ecommercespring.model.Invoice;
import com.hilalsolak.ecommercespring.model.Sale;

import java.util.UUID;

public record InvoiceResponse(UUID id,UUID saleId,String decription) {
    public static InvoiceResponse convert(Invoice from){
        return new InvoiceResponse(from.getId(),
        from.getSale().getId(),
        from.getDescription());
    }

}
