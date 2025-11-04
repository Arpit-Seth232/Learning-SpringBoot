package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {

    @Around("@annotation(TimeMonitor)")
    public Object logtime(ProceedingJoinPoint JoinPoint){

        long start = System.currentTimeMillis();
        Object result = null;

        try{
           result = JoinPoint.proceed();
        }
        catch (Throwable e){

            System.out.println("Something went wrong during execution");

        }
        finally {

            long end = System.currentTimeMillis();

            long totalExecutionTime = end - start;

            System.out.println("Total time of execution of the method is : " + totalExecutionTime + " ms...");
        }
        return result;
    }

}
