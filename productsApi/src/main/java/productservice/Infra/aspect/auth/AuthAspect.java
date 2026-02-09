package productservice.Infra.aspect.auth;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import productservice.Auth.exception.AcessDeniedException;
import productservice.Infra.session.ProductSession;

@Aspect
@Component
public class AuthAspect {
    // Atributos
    private ProductSession productSession;

    // Construtor
    public AuthAspect(ProductSession productSession) {
        this.productSession = productSession;
    }

    // Interceptações
    @Around("@annotation(ToAuthenticate)")
    public Object authenticate(ProceedingJoinPoint joinPoint) throws Throwable {
        if(!productSession.isLogged()) {
            throw new AcessDeniedException()    ;
        }

        return joinPoint.proceed();
    }
}
