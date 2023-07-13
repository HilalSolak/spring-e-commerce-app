package com.hilalsolak.ecommercespring.api;

import com.hilalsolak.ecommercespring.dto.responses.LoggerResponse;
import com.hilalsolak.ecommercespring.service.LoggerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/loggers")
public class LoggerController {
    private final LoggerService service;

    public LoggerController(LoggerService service) {
        this.service = service;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<LoggerResponse> getAll(){
        return service.getAllLoggers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    LoggerResponse getById(@PathVariable UUID id){
        return service.getLoggerById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id){
        service.deleteLoggerById(id);
    }
}
