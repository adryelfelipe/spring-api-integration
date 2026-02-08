package productservice.Product.services;

import clientservice.Auth.exception.AccessDeniedException;
import clientservice.Infra.session.ClientSession;
import org.springframework.stereotype.Service;
import productservice.Auth.exception.AcessDeniedException;
import productservice.Infra.session.AuthSession;
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
    private AuthSession authSession;
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    // Construtor
    public ProductService(AuthSession authSession, ProductRepository productRepository, ProductMapper productMapper) {
        this.authSession = authSession;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    // Métodos
    public void create(CreateProductRequest request) {
        if(!authSession.isLogged()) {
            throw new AcessDeniedException();
        }

        // implementar
    }

    public GetProductResponse get(GetProductRequest request) {
        if(!authSession.isLogged()) {
            throw new AcessDeniedException()    ;
        }

        Optional<Product> optionalProduct = productRepository.getById(request.id());

        if(optionalProduct.isEmpty()) {
            throw new ProducNotFoundException("Produto não encontrado com o id: " + request.id());
        }

        return productMapper.toResponse(optionalProduct.get());
    }
}
