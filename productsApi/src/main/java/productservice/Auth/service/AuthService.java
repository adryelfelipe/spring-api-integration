package productservice.Auth.service;

import org.springframework.stereotype.Service;
import productservice.Auth.exception.AuthenticationFailedException;
import productservice.Infra.session.ProductSession;

@Service
public class AuthService {
    // Atributos
    private ProductSession productSession;

    // Construtor
    public AuthService(ProductSession productSession) {
        this.productSession = productSession;
    }

    // Métodos
    public void authenticate(String password, Long clientId, String client_service_sessionId) {
        if(!password.equals("123")) {
            throw new AuthenticationFailedException();
        }

        productSession.setLogged(true);
        productSession.setClientId(clientId);
        productSession.setClient_service_sessionId("JSESSIONID=" + client_service_sessionId);
    }
}
