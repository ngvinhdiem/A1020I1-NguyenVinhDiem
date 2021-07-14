package vn.codegym.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import vn.codegym.exception.CustomerNotFoundException;
import vn.codegym.exception.DuplicateEmailException;

import java.time.LocalDate;
import java.util.Arrays;

@Aspect
@Component
public class Logger {

    @Pointcut("execution(* vn.codegym.controller.CustomerController.*(..))")
    public void allMethodsPointCut(){}

    @Before("allMethodsPointCut()")
    public void beforeCallService(JoinPoint joinPoint){
        System.err.println("Start method name: " + joinPoint.getSignature().getName() + ". Time: " + LocalDate.now());

    }

    @After("allMethodsPointCut()")
    public void afterCallMethod(JoinPoint joinPoint) {
        System.err.println("End method name: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "allMethodsPointCut()", throwing = "e")
    public void AfterThrowingCallMethod(JoinPoint joinPoint, CustomerNotFoundException e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.err.println(String.format("Exception: %s, %s, %s: %s", className, method, args, e.getMessage()));
    }

    @AfterThrowing(pointcut = "allMethodsPointCut()", throwing = "e")
    public void AfterThrowingCallMethod(JoinPoint joinPoint, DuplicateEmailException e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.err.println(String.format("Exception email: %s, %s, %s: %s", className, method, args, e.getMessage()));
    }
}