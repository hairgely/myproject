package com.hairgely;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestControllerAspect {

    @Before("within(com.hairgely..controller.*Controller)")
    public void logBeforeRestCall(JoinPoint pjp) throws Throwable {
        System.out.println("-----Call-----" + pjp);
    }
}
