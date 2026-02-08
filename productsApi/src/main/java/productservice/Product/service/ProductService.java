package productservice.Product.service;

import org.springframework.stereotype.Service;
import productservice.Auth.exception.AcessDeniedException;
import productservice.Infra.session.ClientSession;
import productservice.Product.dto.create.CreateProductRequest;
import productservice.Product.dto.get.GetProductRequest;
import productservice.Product.dto.get.GetProductResponse;
import productservice.Product.exception.ProducNotFoundException;
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
        if(!clientSession.isLogged()) {
            throw new AcessDeniedException();
        }

        Product product = productMapper.toEntity(request);
        productRepository.save(product);
    }

    public GetProductResponse get(GetProductRequest request) {
        if(!clientSession.isLogged()) {
            throw new AcessDeniedException()    ;
        }

        Optional<Product> optionalProduct = productRepository.getById(request.id());

        if(optionalProduct.isEmpty()) {
            throw new ProducNotFoundException("Produto não encontrado com o id: " + request.id());
        }

        return productMapper.toResponse(optionalProduct.get());
    }
}
