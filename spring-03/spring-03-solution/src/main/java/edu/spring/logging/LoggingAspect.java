package edu.spring.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE + 100)
public class LoggingAspect {

    @Before("@annotation(edu.spring.logging.Loggable)")
    public void logBefore(JoinPoint joinPoint) {
        var method = (MethodSignature) joinPoint.getSignature();
        Loggable annotation =
                method.getMethod().getAnnotation(Loggable.class);
        String template = annotation.value();
        System.out.println(String.format(template, method.getName()));
    }
}
