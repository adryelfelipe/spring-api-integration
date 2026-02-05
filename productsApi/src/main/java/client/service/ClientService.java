package client.service;

import client.dto.create.CreateClientRequest;
import client.dto.get.GetClientRequest;
import client.dto.get.GetClientResponse;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    // Métodos
    public void create(CreateClientRequest request) {
        // implementar
    }

    public GetClientResponse get(GetClientRequest request) {
        // implementar
        return new GetClientResponse("teste", "teste@gmail.com", 3);
    }
}
