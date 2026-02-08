package productservice.Auth.service;

import org.springframework.stereotype.Service;
import productservice.Auth.exception.AuthenticationFailedException;
import productservice.Infra.session.ClientSession;

@Service
public class AuthService {
    // Atributos
    private ClientSession clientSession;

    // Construtor
    public AuthService(ClientSession clientSession) {
        this.clientSession = clientSession;
    }

    // Métodos
    public void authenticate(String password, Long clientId) {
        if(!password.equals("123")) {
            throw new AuthenticationFailedException();
        }

        clientSession.setLogged(true);
        clientSession.setClientId(clientId);
    }
}
