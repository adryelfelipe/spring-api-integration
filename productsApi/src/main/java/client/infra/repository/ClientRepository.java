package client.infra.repository;

import client.dto.get.GetClientResponse;
import client.model.Client;

public interface ClientRepository {
    void save(Client client);
    GetClientResponse get(Client client);
}
