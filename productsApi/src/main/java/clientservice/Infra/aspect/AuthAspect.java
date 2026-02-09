package clientservice.Infra.aspect;

import clientservice.Auth.exception.AccessDeniedException;
import clientservice.Infra.session.ClientSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
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
