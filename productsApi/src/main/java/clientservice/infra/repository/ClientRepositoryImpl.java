package clientservice.Infra.repository;

import clientservice.Client.model.Client;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
    public Optional<Client> getById(long id) {
        return jpaClientRepository.findById(id);
    }

    @Override
    public Optional<Client> getByEmail(String email) {
        return jpaClientRepository.findByEmail(email);
    }
}
