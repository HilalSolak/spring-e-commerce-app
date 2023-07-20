package com.hilalsolak.ecommercespring.model.dto.responses;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ExceptionResponse(HttpStatus status, String path, LocalDateTime timestamp, String message) {

}
