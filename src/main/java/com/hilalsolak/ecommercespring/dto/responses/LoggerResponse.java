package com.hilalsolak.ecommercespring.dto.responses;

import com.hilalsolak.ecommercespring.model.Logger;
import java.time.LocalDateTime;
import java.util.UUID;

public record LoggerResponse(UUID id, String clientId, String activityType, LocalDateTime createdAt) {
    public static LoggerResponse convert(Logger from)  {
        return new LoggerResponse(from.getId(),
                from.getClientId(),
                from.getActivityType(),
                from.getCreatedAt());
    }
}
