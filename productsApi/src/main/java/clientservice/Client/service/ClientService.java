package clientservice.Client.service;

import clientservice.Client.dto.create.CreateClientRequest;
import clientservice.Client.dto.get.GetClientRequest;
import clientservice.Client.dto.get.GetClientResponse;
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
