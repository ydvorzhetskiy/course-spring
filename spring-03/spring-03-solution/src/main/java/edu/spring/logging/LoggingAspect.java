package edu.spring.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE + 100)
public class LoggingAspect {



    @Before(value = "@annotation(args)", argNames = "joinPoint,args")
    public void logBefore(JoinPoint joinPoint, Loggable args) {
        String template = args.value();
        System.out.println(
                String.format(template, joinPoint.getSignature().getName())
        );
    }
}
