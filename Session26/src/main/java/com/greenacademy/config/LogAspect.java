package com.greenacademy.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("within(com.greenacademy.service.impl.*)")
    public void logPointcutService() {}

    @Pointcut("within(com.greenacademy.api.*)")
    public void logPointcutApi() {}


    @Around("logPointcutService() || logPointcutApi()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis() - startTime;
        LOGGER.info("[EXECUTED] LogAspect {}.{} executed in {} ms", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), endTime);
        return result;
    }
}
