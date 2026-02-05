package clientservice.Auth.service;

import clientservice.Auth.dto.login.LoginRequest;
import clientservice.Client.exception.ClientNotFoundException;
import clientservice.infra.repository.ClientRepository;
import clientservice.infra.session.ClientSession;
import clientservice.Client.model.Client;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    // Atributos
    private ClientSession clientSession;
    private ClientRepository clientRepository;

    // Construtor
    public AuthService(ClientSession clientSession, ClientRepository clientRepository) {
        this.clientSession = clientSession;
        this.clientRepository = clientRepository;
    }

    // Métodos
    public void login(LoginRequest request) {
        // implementar validação
        Optional<Client> optionalClient = clientRepository.getByEmail(request.email());

        if(optionalClient.isEmpty()) {
            throw new ClientNotFoundException(request.email());
        }

        Client client = optionalClient.get();

        if(client.getPassword().equals(request.password())) {
            clientSession.setId(client.getId());
            clientSession.setName(client.getName());
        }
    }
}
