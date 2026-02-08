package productservice.Infra.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class ProductSession {
    // Atributos
    private boolean logged;
    private Long clientId;
    private String client_service_sessionId;

    // Getters and Setters
    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClient_service_sessionId() {
        return client_service_sessionId;
    }

    public void setClient_service_sessionId(String client_service_sessionId) {
        this.client_service_sessionId = client_service_sessionId;
    }
}
