package clientservice.Auth.service;

import clientservice.Auth.dto.login.ClientLoginRequest;
import clientservice.Auth.dto.register.ClientRegisterRequest;
import clientservice.Auth.exception.InvalidCredentialsException;
import clientservice.Client.exception.ClientEmailAlreadyUsed;
import clientservice.Client.mapper.ClientMapper;
import clientservice.Infra.feign.ClientFeignClient;
import clientservice.Infra.repository.ClientRepository;
import clientservice.Infra.session.ClientSession;
import clientservice.Client.model.Client;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    // Atributos
    private ClientSession clientSession;
    private ClientRepository clientRepository;
    private ClientMapper clientMapper;
    private ClientFeignClient clientFeignClient;

    // Construtor
    public AuthService(ClientSession clientSession, ClientRepository clientRepository, ClientMapper clientMapper, ClientFeignClient clientFeignClient) {
        this.clientSession = clientSession;
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
        this.clientFeignClient = clientFeignClient;
    }

    // Métodos
    public String login(ClientLoginRequest request, String service_sessionId) {
        Optional<Client> optionalClient = clientRepository.getByEmail(request.email());

        if(optionalClient.isEmpty()) {
            throw new InvalidCredentialsException();
        }

        Client client = optionalClient.get();

        if(client.getPassword().equals(request.password())) {
            clientSession.setLogged(true);
            return clientFeignClient.authenticate("123", client.getId(), service_sessionId);
        } else {
            throw new InvalidCredentialsException();
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
