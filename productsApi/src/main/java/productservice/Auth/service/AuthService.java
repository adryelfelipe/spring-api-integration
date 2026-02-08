package productservice.Auth.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import productservice.Auth.exception.AuthenticationFailedException;
import productservice.Infra.session.AuthSession;

@Service
public class AuthService {
    // Atributos
    private AuthSession authSession;

    // Construtor
    public AuthService(AuthSession authSession) {
        this.authSession = authSession;
    }

    // Métodos
    public void authenticate(String password) {
        if(!password.equals("123")) {
            throw new AuthenticationFailedException();
        }

        authSession.setLogged(true);
    }
}
