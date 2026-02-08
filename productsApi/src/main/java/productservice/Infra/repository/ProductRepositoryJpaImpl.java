package productservice.Infra.repository;

import org.springframework.stereotype.Repository;
import productservice.Product.model.Product;

import java.util.Optional;

@Repository
public class ProductRepositoryJpaImpl implements ProductRepository {
    // Atributos
    private JpaProductRepository jpaRepository;

    // Construtor
    public ProductRepositoryJpaImpl(JpaProductRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    // Métodos
    @Override
    public void save(Product product) {
        jpaRepository.save(product);
    }

    @Override
    public Optional<Product> getById(Long id) {
        return jpaRepository.findById(id);
    }
}
