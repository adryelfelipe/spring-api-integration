package clientservice.Client.service;

import clientservice.Client.dto.create.CreateClientRequest;
import clientservice.Client.dto.get.GetClientRequest;
import clientservice.Client.dto.get.GetClientResponse;
import clientservice.Client.exception.ClientNotFoundException;
import clientservice.Client.mapper.ClientMapper;
import clientservice.Client.model.Client;
import clientservice.Infra.aspect.Auth.ToAuthenticate;
import clientservice.Infra.aspect.Logging.ToLog;
import clientservice.Infra.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ClientService {
    // Atributos
    private ClientRepository clientRepository;
    private ClientMapper clientMapper;
    private Logger logger = LoggerFactory.getLogger(ClientService.class);

    // Construtor
    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    // Métodos
    @ToAuthenticate
    @ToLog
    public void create(CreateClientRequest request) {
        Client client = clientMapper.toEntity(request);
        clientRepository.save(client);
        logger.info("Cliente criado com sucesso, ID: {}", client.getId());
    }

    @ToAuthenticate
    @ToLog
    public GetClientResponse get(GetClientRequest request) {
        Optional<Client> optionalClient = clientRepository.getById(request.id());

        if(optionalClient.isEmpty()) {
            throw new ClientNotFoundException("Cliente não encontrado com o id: " + request.id());
        }

        GetClientResponse response = clientMapper.toResponse(optionalClient.get());
        logger.info("Cliente retornado com sucesso, ID: {}", response.id());

        return clientMapper.toResponse(optionalClient.get());
    }
}
