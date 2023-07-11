package com.hilalsolak.ecommercespring.service.impl;

import com.hilalsolak.ecommercespring.constants.GlobalConstants;
import com.hilalsolak.ecommercespring.dto.responses.LoggerResponse;
import com.hilalsolak.ecommercespring.exception.EntityNotFoundException;
import com.hilalsolak.ecommercespring.model.Logger;
import com.hilalsolak.ecommercespring.repository.LoggerRepository;
import com.hilalsolak.ecommercespring.service.LoggerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class LoggerServiceImpl implements LoggerService {

    private final LoggerRepository repository;

    public LoggerServiceImpl(LoggerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LoggerResponse> getAll() {
        List<LoggerResponse> response = repository.findAll().stream().map(LoggerResponse::convert).toList();

        return response;
    }

    @Override
    public LoggerResponse getById(UUID id) {
        Logger logger = getLoggerById(id);
        LoggerResponse response = LoggerResponse.convert(logger);

        return response;
    }

    @Override
    public void create(String clientId, String activityType) {
         Logger logger = new Logger();
         logger.setClientId(clientId);
         logger.setActivityType(activityType);
         repository.save(logger);
    }

    @Override
    public void delete(UUID id) {
        Logger logger = getLoggerById(id);
        repository.delete(logger);
    }
    private Logger getLoggerById(UUID id) {
        return repository.findById(id).orElseThrow(()->new EntityNotFoundException(GlobalConstants.LOGGER_NOT_FOUND));

    }
}
