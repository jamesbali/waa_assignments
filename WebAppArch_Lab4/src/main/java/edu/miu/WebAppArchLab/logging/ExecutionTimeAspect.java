package edu.miu.WebAppArchLab.logging;


import edu.miu.WebAppArchLab.repository.LoggerRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Autowired
    private LoggerRepository loggerRepository;

    @Around("@annotation(ExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        Logger logger = new Logger();
        logger.setTransactionId(UUID.randomUUID().toString());
        logger.setLocalDateTime(LocalDateTime.now());
        logger.setPrinciple("PrincipleUser");
        logger.setOperation(joinPoint.getSignature().getName() + " executed in " + executionTime + "ms");

        loggerRepository.save(logger);

        return proceed;



    }

}
