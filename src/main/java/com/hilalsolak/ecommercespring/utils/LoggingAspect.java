package com.hilalsolak.ecommercespring.utils;

import com.hilalsolak.ecommercespring.service.LoggerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

@Aspect //bu classımızın aspect olduğunu söylüyoruz bu anotasyonla.
// Applicationda yazdığımız enableaspectjautoproxy ile de bu classımızın aspect olduğunu buluyor
public class LoggingAspect {
    private final LoggerService loggerService;

    public LoggingAspect(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    @Around("execution(* com.hilalsolak.ecommercespring.api.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String clientId =  RequestContextHolder.currentRequestAttributes().getSessionId();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String activityType = "Class: "+ className +" Method: " + methodName + " is called";
        loggerService.createLogger(clientId,activityType);
        // Metodu çağırarak devam etmek için proceed() yöntemini kullanın

        Object returnedValue = joinPoint.proceed();

        return returnedValue;


    }

}
