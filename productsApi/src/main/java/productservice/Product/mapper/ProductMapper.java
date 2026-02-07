package productservice.Product.mapper;

import org.springframework.stereotype.Component;
import productservice.Product.dto.get.GetProductResponse;
import productservice.Product.model.Product;

@Component
public class ProductMapper {
    public GetProductResponse toResponse(Product product) {

        return new GetProductResponse(
                product.getName(),
                null,
                product.getPrice(),
                product.getClientId()
        );
    }
}
