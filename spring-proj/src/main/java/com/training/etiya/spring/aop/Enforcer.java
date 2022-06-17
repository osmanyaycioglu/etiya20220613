package com.training.etiya.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Enforcer {

    // @Around("execution(* com.training.etiya.spring.di.Greetings.*(..))")
    public Object aroundCut(ProceedingJoinPoint pjp) {
        try {
            Object[] args = pjp.getArgs();
            Signature signature = pjp.getSignature();
            System.out.println("Joining : " + signature);
            for (Object obj : args) {
                System.out.println("Args : " + obj);
            }
            Object[] args2 = new Object[1];
            args2[0] = "intercepted osman";

            // Object proceed = pjp.proceed(args2);
            return null;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Around("@annotation(sMe)")
    public Object secureCut(ProceedingJoinPoint pjp,
                            SecureMe sMe) {
        try {
            System.out.println("Checking security for : " + pjp.getSignature());
            String[] roles = sMe.value();
            if (roles[0].equals("osman")){
                return pjp.proceed();
            } else {
                return null;
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
