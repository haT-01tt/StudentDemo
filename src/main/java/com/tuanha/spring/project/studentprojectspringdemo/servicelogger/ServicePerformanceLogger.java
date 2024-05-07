package com.tuanha.spring.project.studentprojectspringdemo.servicelogger;
import com.tuanha.spring.project.studentprojectspringdemo.custom.LogSaveOperation;
import com.tuanha.spring.project.studentprojectspringdemo.custom.LogServicePerformance;
import com.tuanha.spring.project.studentprojectspringdemo.utils.ModelUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ServicePerformanceLogger {
    private long startTime;
    @Autowired
    ModelUtils utils;
    @Autowired
    private HttpServletRequest request;

    @Before("@annotation(logServicePerformance)")
    public void logServiceMethod(JoinPoint joinPoint, LogServicePerformance logServicePerformance) {
        log.info("Service method: " + utils.getUrl(joinPoint, request));
        log.info("Description: " + logServicePerformance.value());
        startTime = System.currentTimeMillis();
    }
    @Before("@annotation(logSaveOperation)")
    public void logSaveMethod(JoinPoint joinPoint, LogSaveOperation logSaveOperation) {
        log.info("Service method: " + utils.getUrl(joinPoint, request));
        log.info("Description: " + logSaveOperation.value());
    }

    @AfterReturning(pointcut = "@annotation(logServicePerformance)", returning = "result")
    public void logServiceMethodPerformance(JoinPoint joinPoint, Object result, LogServicePerformance logServicePerformance) {
        long executionTime = System.currentTimeMillis() - startTime;
        log.info("Execution time of " + utils.getUrl(joinPoint, request) +
                " method: " + executionTime + "ms");
    }
}
