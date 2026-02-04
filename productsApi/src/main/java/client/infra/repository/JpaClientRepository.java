package client.infra.repository;

import client.model.Client;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface JpaClientRepository extends JpaRepository<Client, Long> {

}
