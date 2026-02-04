package client.infra.repository;

import client.model.Client;

public interface ClientRepository {
    void save(Client client);
}
