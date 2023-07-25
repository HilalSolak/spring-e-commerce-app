package com.hilalsolak.ecommercespring.converters;

import com.hilalsolak.ecommercespring.model.dto.responses.*;
import com.hilalsolak.ecommercespring.model.entities.*;

import java.util.List;

public class ConverterResponse {

    public static CategoryResponse convert(Category from){
        return new CategoryResponse(from.getId(), from.getName(),
                from.getProducts().stream().map(ConverterResponse::convertCategoryProduct).toList());

    }
    public static InvoiceResponse convert(Invoice from){
        return new InvoiceResponse(from.getId(),
                from.getSale().getId(),
                from.getDescription());
    }
    public static CategoryProductResponse convertCategoryProduct(Product from){
        return new CategoryProductResponse(from.getId().toString(),from.getCategory().getName(), from.getName(),from.getDescription());
    }

    public static PaymentResponse convert(Payment from){
        return new PaymentResponse(from.getId(),
                from.getCardHolder(),
                from.getCardNumber(),
                from.getCardExpiredMonth(),
                from.getCardExpiredYear(),
                from.getCardCvv(),
                from.getBalance());
    }

    public static LoggerResponse convert(Logger from)  {
        return new LoggerResponse(from.getId(),
                from.getClientId(),
                from.getActivityType(),
                from.getCreatedAt());
    }
    public static ProductResponse convert(Product from){
        return new ProductResponse(from.getId(),
                from.getName(),
                from.getDescription(),
                from.getPrice(),
                from.getQuantity(),
                ConverterResponse.convert(from.getCategory()));
    }

    public static SaleResponse convert(Sale from) {
        List<ProductResponse> response = from.getProducts().stream().map(ConverterResponse::convert).toList();
        return new SaleResponse(from.getId(),from.getDescription(),from.getTotalPrice(),response);
    }

}
