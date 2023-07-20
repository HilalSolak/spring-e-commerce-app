package com.hilalsolak.ecommercespring.service.impl;

import com.hilalsolak.ecommercespring.converters.ConverterResponse;
import com.hilalsolak.ecommercespring.utils.advice.exceptions.EntityNotFoundException;
import com.hilalsolak.ecommercespring.utils.constants.GlobalConstants;
import com.hilalsolak.ecommercespring.model.dto.responses.LoggerResponse;
import com.hilalsolak.ecommercespring.model.entities.Logger;
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
    public List<LoggerResponse> getAllLoggers() {
        List<LoggerResponse> response = repository.findAll().stream().map(ConverterResponse::convert).toList();

        return response;
    }

    @Override
    public LoggerResponse getLoggerById(UUID id) {
        Logger logger = getLoggerByIdInRepository(id);
        LoggerResponse response = ConverterResponse.convert(logger);

        return response;
    }

    @Override
    public void createLogger(String clientId, String activityType) {
         Logger logger = new Logger();
         logger.setClientId(clientId);
         logger.setActivityType(activityType);
         repository.save(logger);
    }

    @Override
    public void deleteLoggerById(UUID id) {
        Logger logger = getLoggerByIdInRepository(id);
        repository.delete(logger);
    }
    private Logger getLoggerByIdInRepository(UUID id) {
        return repository.findById(id).orElseThrow(()->new EntityNotFoundException(GlobalConstants.LOGGER_NOT_FOUND));

    }
}
