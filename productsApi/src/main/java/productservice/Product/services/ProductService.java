package productservice.Product.services;

import clientservice.Auth.exception.AccessDeniedException;
import clientservice.Infra.session.ClientSession;
import org.springframework.stereotype.Service;
import productservice.Product.dto.create.CreateProductRequest;
import productservice.Product.dto.get.GetProductRequest;
import productservice.Product.dto.get.GetProductResponse;
import productservice.Product.exceptions.ProducNotFoundException;
import productservice.Product.mapper.ProductMapper;
import productservice.Product.model.Product;
import productservice.Infra.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {
    // Atributos
    private ClientSession clientSession;
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    // Construtor
    public ProductService(ClientSession clientSession, ProductRepository productRepository, ProductMapper productMapper) {
        this.clientSession = clientSession;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    // Métodos
    public void create(CreateProductRequest request) {
        if(clientSession.getName().isEmpty()) {
            throw new AccessDeniedException();
        }

        // implementar
    }

    public GetProductResponse get(GetProductRequest request) {
        if(clientSession.getName().isEmpty()) {
            throw new AccessDeniedException();
        }

        Optional<Product> optionalProduct = productRepository.getById(request.id());

        if(optionalProduct.isEmpty()) {
            throw new ProducNotFoundException("Produto não encontrado com o id: " + request.id());
        }

        return productMapper.toResponse(optionalProduct.get());
    }
}
