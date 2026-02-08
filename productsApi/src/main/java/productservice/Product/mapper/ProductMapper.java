package productservice.Product.mapper;

import org.springframework.stereotype.Component;
import productservice.Infra.session.ClientSession;
import productservice.Product.dto.create.CreateProductRequest;
import productservice.Product.dto.get.GetProductResponse;
import productservice.Product.model.Product;

@Component
public class ProductMapper {
    // Atributos
    private ClientSession clientSession;

    // Construtor
    public ProductMapper(ClientSession clientSession) {
        this.clientSession = clientSession;
    }

    // Métodos de conversão
    public GetProductResponse toResponse(Product product) {

        return new GetProductResponse(
                product.getName(),
                null,
                product.getPrice(),
                product.getClientId()
        );
    }

    public Product toEntity(CreateProductRequest request) {

        return new Product(
                null,
                request.name(),
                request.price(),
                clientSession.getClientId()
        );
    }
}
