package clientservice.infra.repository;

import clientservice.Client.model.Client;

import java.util.Optional;

public interface ClientRepository {
    void save(Client client);
    Optional<Client> getById(long id);
    Optional<Client> getByEmail(String email);
}
