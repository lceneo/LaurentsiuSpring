package aspects;

import entities.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    @Around("execution(String services.CommentService.publishComment(entities.Comment))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        var methodName = joinPoint.getSignature().getName();
        var args = joinPoint.getArgs();
        var comment = new Comment();

        logger.info("Method " + methodName + " will execute with parameters: " + Arrays.asList(args));
        var returnedValue = joinPoint.proceed(new Object[] {comment});
        logger.info("Method executed and returned " + returnedValue);
        return returnedValue;
    }
}
