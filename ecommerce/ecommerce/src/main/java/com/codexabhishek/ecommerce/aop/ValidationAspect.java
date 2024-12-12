package com.codexabhishek.ecommerce.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger lg = LoggerFactory.getLogger(ValidationAspect.class);
    @Around("execution(* com.codexabhishek.ecommerce.service.ProductService.getProductById(..)) && args(productId)")
    public Object validationAspect(ProceedingJoinPoint jp,int productId) throws Throwable{
        if(productId < 0){
            productId = -productId;
        }
        Object obj = jp.proceed(new Object[]{productId});
        lg.info("new value"+productId);
        return obj;
    }
}
