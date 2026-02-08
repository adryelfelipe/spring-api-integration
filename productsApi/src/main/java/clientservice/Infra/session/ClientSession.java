package clientservice.Infra.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Optional;

@Component
@SessionScope
public class ClientSession {
    // Atributos
    private boolean logged;

    // Getters and Setters
    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
}
