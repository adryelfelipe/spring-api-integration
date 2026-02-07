package productservice.Infra.repository;

import productservice.Product.model.Product;

import java.util.Optional;

public interface ProductRepository {
    void save(Product product);
    Optional<Product> getById(Long id);
}
