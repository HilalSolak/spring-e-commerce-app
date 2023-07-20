package com.hilalsolak.ecommercespring.service;

import com.hilalsolak.ecommercespring.model.dto.responses.LoggerResponse;

import java.util.List;
import java.util.UUID;

public interface LoggerService {
    List<LoggerResponse> getAllLoggers();
    LoggerResponse getLoggerById(UUID id);
    void createLogger(String clientId, String activityType);
    void deleteLoggerById(UUID id);
}
