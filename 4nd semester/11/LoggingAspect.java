import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
 
@Aspect
@Component
 
public class LoggingAspect {
 
    @Before("execution(* someWhereRepository.*(..))")
    public void logBefore(JoinPoint joinPoint) {
 
        System.out.println("!log");
        System.out.println("watch " + joinPoint.getSignature().getName());
    }
 
    @AfterThrowing (pointcut = "execution(* *(..))", throwing = "ex")
    public void logAllThrowingMethods(Exception ex) throws Throwable {
        System.err.println("Exception throwed : "+ ex);
    }
 
    @Before("@annotation(MyLog)")
    public void log(JoinPoint joinPoint) throws Throwable {
        System.out.println("watch " + joinPoint.getSignature().getName());
    }
}