package productservice.Infra.aspect.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
    // Atributos
    private Logger logger = LoggerFactory.getLogger(clientservice.Infra.aspect.Logging.LoggingAspect.class);

    // Interceptações
    @Around("@annotation(ToLog)")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringType().getName();
        String methodName = joinPoint.getSignature().getName();

        logger.info("Entrando no método {}.{}", className, methodName);
        Object methodReturnment = joinPoint.proceed();
        logger.info("Saindo do método {}.{}", className, methodName);

        return methodReturnment;
    }
}
