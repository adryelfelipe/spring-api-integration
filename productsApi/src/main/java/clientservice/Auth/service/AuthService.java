package clientservice.Auth.service;

import clientservice.Auth.dto.login.ClientLoginRequest;
import clientservice.Auth.dto.register.ClientRegisterRequest;
import clientservice.Client.exception.ClientEmailAlreadyUsed;
import clientservice.Client.exception.ClientNotFoundException;
import clientservice.Client.mapper.ClientMapper;
import clientservice.Infra.repository.ClientRepository;
import clientservice.Infra.session.ClientSession;
import clientservice.Client.model.Client;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    // Atributos
    private ClientSession clientSession;
    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    // Construtor
    public AuthService(ClientSession clientSession, ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientSession = clientSession;
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    // Métodos
    public void login(ClientLoginRequest request) {
        Optional<Client> optionalClient = clientRepository.getByEmail(request.email());

        if(optionalClient.isEmpty()) {
            throw new ClientNotFoundException("Cliente não encontrado com o email: " + request.email());
        }

        Client client = optionalClient.get();

        if(client.getPassword().equals(request.password())) {
            clientSession.setId(client.getId());
            clientSession.setName(client.getName());
        }
    }

    public void register(ClientRegisterRequest request) {
        Optional<Client> optionalClient = clientRepository.getByEmail(request.email());

        if(optionalClient.isPresent()) {
            throw new ClientEmailAlreadyUsed(request.email());
        }

        Client client = clientMapper.toEntity(request);
        clientRepository.save(client);
    }
}
