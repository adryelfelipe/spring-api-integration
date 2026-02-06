package clientservice.Client.mapper;

import clientservice.Auth.dto.register.ClientRegisterRequest;
import clientservice.Client.dto.create.CreateClientRequest;
import clientservice.Client.dto.get.GetClientResponse;
import clientservice.Client.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    // Métodos
    public Client toEntity(ClientRegisterRequest request) {

        return new Client(
                request.name(),
                request.password(),
                request.email(),
                null);
    }

    public Client toEntity(CreateClientRequest request) {

        return new Client(
                request.name(),
                request.password(),
                request.email(),
                null);
    }

    public GetClientResponse toResponse(Client client) {

        return new GetClientResponse(
                client.getName(),
                client.getEmail(),
                client.getId()
        );
    }
}
