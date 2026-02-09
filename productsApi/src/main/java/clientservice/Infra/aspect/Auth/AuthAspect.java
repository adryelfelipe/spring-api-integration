package clientservice.Infra.aspect.Auth;

import clientservice.Auth.exception.AccessDeniedException;
import clientservice.Infra.session.ClientSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class AuthAspect {
    // Atributos
    public ClientSession clientSession;

    // Construtor
    public AuthAspect(ClientSession clientSession) {
        this.clientSession = clientSession;
    }

    // Advices
    @Around("@annotation(ToAuthenticate)")
    public Object authenticate(ProceedingJoinPoint joinPoint) throws Throwable {
        if(!clientSession.isLogged()) {
            throw new AccessDeniedException();
        }

        return joinPoint.proceed();
    }
}
