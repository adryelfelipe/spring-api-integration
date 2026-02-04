package client.infra.repository;

import client.dto.get.GetClientResponse;
import client.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final JpaClientRepository jpaClientRepository;

    public ClientRepositoryImpl(JpaClientRepository jpaClientRepository) {
        this.jpaClientRepository = jpaClientRepository;
    }

    @Override
    public void save(Client client) {
        jpaClientRepository.save(client);
    }

    @Override
    public GetClientResponse get(Client client) {
        // Converte o Objeto para o Dto
        return new GetClientResponse(
                client.getName(),
                client.getEmail(),
                client.getId()
        );
    }
}
