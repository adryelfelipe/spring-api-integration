package productservice.services;

import clientservice.Auth.exception.AccessDeniedException;
import clientservice.infra.session.ClientSession;
import org.springframework.stereotype.Service;
import productservice.dto.create.CreateProductRequest;
import productservice.dto.get.GetProductRequest;
import productservice.dto.get.GetProductResponse;

@Service
public class ProductService {
    // Atributos
    private ClientSession clientSession;

    // Construtor
    public ProductService(ClientSession clientSession) {
        this.clientSession = clientSession;
    }

    // Métodos
    public void save(CreateProductRequest request) {
        if(clientSession.getName().isEmpty()) {
            throw new AccessDeniedException();
        }

        // implementar
    }

    public GetProductResponse get(GetProductRequest request) {
        if(clientSession.getName().isEmpty()) {
            throw new AccessDeniedException();
        }

        // implementar

        return new GetProductResponse("abababa", 2, 22, 5);
    }
}
