package com.hilalsolak.ecommercespring.utils;

import com.hilalsolak.ecommercespring.service.LoggerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.request.RequestContextHolder;

@Aspect //bu classımızın aspect olduğunu söylüyoruz bu anotasyonla.
// Applicationda yazdığımız enableaspectjautoproxy ile de bu classımızın aspect olduğunu buluyor
@Scope("singleton")
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class.getName());
    private final LoggerService loggerService;

    public LoggingAspect(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    @Around("execution(* com.hilalsolak.ecommercespring.api.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        String clientId =  RequestContextHolder.currentRequestAttributes().getSessionId();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String activityType = "Class: "+ className +" Method: " + methodName + " is called";

        // Metodu çağırarak devam etmek için proceed() yöntemini kullanın
        joinPoint.proceed();

        loggerService.create(clientId,activityType);
    }

}
