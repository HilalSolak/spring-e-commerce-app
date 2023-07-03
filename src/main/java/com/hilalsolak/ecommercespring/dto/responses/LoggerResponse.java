package com.hilalsolak.ecommercespring.dto.responses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonElement;
import com.hilalsolak.ecommercespring.model.Logger;
import com.hilalsolak.ecommercespring.utils.LoggerHelper;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public record LoggerResponse(UUID id, Map<String,Object> request , Map<String,Object> response, LocalDateTime createdAt) {
    public static LoggerResponse convert(Logger from)  {
        return new LoggerResponse(from.getId(),
                LoggerHelper.convertStringToJson(from.getRequest()),
                LoggerHelper.convertStringToJson(from.getResponse()),
                from.getCreatedAt());
    }
}
