package productservice.Product.mapper;

import clientservice.Client.dto.get.GetClientResponse;
import org.springframework.stereotype.Component;
import productservice.Infra.session.ProductSession;
import productservice.Product.dto.create.CreateProductRequest;
import productservice.Product.dto.get.GetProductResponse;
import productservice.Product.model.Product;

@Component
public class ProductMapper {
    // Atributos
    private ProductSession productSession;

    // Construtor
    public ProductMapper(ProductSession productSession) {
        this.productSession = productSession;
    }

    // Métodos de conversão
    public GetProductResponse toResponse(Product product, GetClientResponse client) {

        return new GetProductResponse(
                product.getName(),
                product.getId(),
                product.getPrice(),
                client
        );
    }

    public Product toEntity(CreateProductRequest request) {

        return new Product(
                null,
                request.name(),
                request.price(),
                productSession.getClientId()
        );
    }
}
