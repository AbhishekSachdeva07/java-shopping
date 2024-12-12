package com.codexabhishek.ecommerce.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
    // return type, class name.method-name, args
    @Before("execution(* com.codexabhishek.ecommerce.service.ProductService.getProductById(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called"+jp.getSignature().getName());
    }
    @After("execution(* com.codexabhishek.ecommerce.service.ProductService.getProductById(..))")
    public void logMethodCalled(JoinPoint jp){
        LOGGER.info("Method Called after "+jp.getSignature().getName());
    }
    @AfterThrowing("execution(* com.codexabhishek.ecommerce.service.ProductService.getProductById(..))")
    public void logMethodAfterThrowing(JoinPoint jp){
        LOGGER.info("Method Called after some errors "+jp.getSignature().getName());
    }
    @AfterReturning("execution(* com.codexabhishek.ecommerce.service.ProductService.getProductById(..))")
    public void logMethodAfterReturing(JoinPoint jp){
        LOGGER.info("Method Called after some errors "+jp.getSignature().getName());
    }
}
