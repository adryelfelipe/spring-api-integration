package product.services;

import org.springframework.stereotype.Service;
import product.dto.create.CreateProductRequest;
import product.dto.get.GetProductRequest;
import product.dto.get.GetProductResponse;

@Service
public class ProductService {
    // Métodos
    public void save(CreateProductRequest request) {
        // implementar
    }

    public GetProductResponse get(GetProductRequest request) {
        // implementar
        return new GetProductResponse("abababa", 2, 22);
    }
}
