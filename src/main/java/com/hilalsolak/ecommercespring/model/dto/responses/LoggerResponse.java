package com.hilalsolak.ecommercespring.model.dto.responses;

import java.time.LocalDateTime;
import java.util.UUID;

public record LoggerResponse(UUID id, String clientId, String activityType, LocalDateTime createdAt) {

}
