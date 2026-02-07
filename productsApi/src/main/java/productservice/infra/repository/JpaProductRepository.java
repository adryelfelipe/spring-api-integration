package productservice.Infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import productservice.Product.model.Product;

import java.util.Optional;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
}
