package com.aadi.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogTracker {
    @Pointcut("within(com..service.*) || within(com..repo.*)")
    public void logMethodPointCut(){

    }

    @Around("logMethodPointCut()")
    public Object BeforeAfterMethodCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Method start : " + proceedingJoinPoint.getSignature().getName());
        Object returnValue = proceedingJoinPoint.proceed();
        System.out.println("  " + returnValue);

        System.out.println("Method ended : " + proceedingJoinPoint.getSignature().getName());
        return returnValue;
    }
    /*
    @Before("logMethodPointCut()")
    public void LogBeforeMethodCall(){
        System.out.println("Method is starting");
    }

    @After("logMethodPointCut()")
    public void LogAfterMethodCall(){
        System.out.println("Method has ended");
    }
    */
}
