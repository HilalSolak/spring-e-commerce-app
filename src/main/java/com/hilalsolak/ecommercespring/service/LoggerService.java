package com.hilalsolak.ecommercespring.service;

import com.hilalsolak.ecommercespring.dto.responses.LoggerResponse;

import java.util.List;
import java.util.UUID;

public interface LoggerService {
    List<LoggerResponse> getAll();
    LoggerResponse getById(UUID id);
    void create(String request, String response);
    void delete(UUID id);
}
