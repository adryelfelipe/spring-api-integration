package clientservice.Infra.repository;

import clientservice.Client.model.Client;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface JpaClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByEmail(String email);
}
