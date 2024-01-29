package com.learning.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.learning..*.*(..))")
    public void beforeMethodExecution(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " started executing...");
    }

    @After("execution(* com.learning..*.*(..))")
    public void afterMethodExecution(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " completed execution");
    }

    @AfterReturning(pointcut = "execution(String com.learning..*.*(..))", returning = "result")
    public void afterMethodReturnsValue(String result) {
        System.out.println("Method returned : " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.learning..*.*(..))", throwing = "ex")
    public void methodThrowingException(JoinPoint point, Throwable ex) {
        System.out.println(point.getSignature().getName() + " has thrown exception " + ex);
    }

}
