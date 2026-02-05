package clientservice.Client.mapper;

import clientservice.Auth.dto.register.ClientRegisterRequest;
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
}
