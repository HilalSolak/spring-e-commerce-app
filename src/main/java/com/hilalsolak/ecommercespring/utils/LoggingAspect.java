package com.hilalsolak.ecommercespring.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class.getName());

    @Around("execution(* com.hilalsolak.ecommercespring.api.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("Class: {}, Method: {} is called", className, methodName);

        // Metodu çağırarak devam etmek için proceed() yöntemini kullanın
        joinPoint.proceed();

        logger.info("Class: {}, Method: {} is completed", className, methodName);
    }

}
