package com.codexabhishek.ecommerce.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMoniteringAspect {

    private static final Logger lg = LoggerFactory.getLogger(PerformanceMoniteringAspect.class);
    @Around("execution(* com.codexabhishek.ecommerce.service.ProductService.getProductById(..)")
    public Object moniterTime(ProceedingJoinPoint jp) throws Throwable{
        long start = System.currentTimeMillis();
        Object obj = jp.proceed();
        long end = System.currentTimeMillis();
        lg.info("Time Taken: "+(end-start));
        return obj;
    }
}
