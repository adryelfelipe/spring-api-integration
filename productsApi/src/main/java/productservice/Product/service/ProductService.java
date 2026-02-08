package productservice.Product.service;

import clientservice.Client.dto.get.GetClientResponse;
import org.springframework.stereotype.Service;
import productservice.Auth.exception.AcessDeniedException;
import productservice.Infra.feign.ProductFeignClient;
import productservice.Infra.session.ProductSession;
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
    private ProductSession productSession;
    private ProductRepository productRepository;
    private ProductMapper productMapper;
    private ProductFeignClient productFeignClient;

    // Construtor
    public ProductService(ProductSession productSession, ProductRepository productRepository, ProductMapper productMapper, ProductFeignClient productFeignClient) {
        this.productSession = productSession;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productFeignClient = productFeignClient;
    }

    // Métodos
    public void create(CreateProductRequest request) {
        if(!productSession.isLogged()) {
            throw new AcessDeniedException();
        }

        Product product = productMapper.toEntity(request);
        productRepository.save(product);
    }

    public GetProductResponse get(GetProductRequest request) {
        if(!productSession.isLogged()) {
            throw new AcessDeniedException()    ;
        }

        Optional<Product> optionalProduct = productRepository.getById(request.id());

        if(optionalProduct.isEmpty()) {
            throw new ProducNotFoundException("Produto não encontrado com o id: " + request.id());
        }

        Product product = optionalProduct.get();
        GetClientResponse client = productFeignClient.getClient(product.getClientId(), productSession.getClient_service_sessionId());

        return productMapper.toResponse(product, client);
    }
}
