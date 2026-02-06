package productservice.Product.services;

import clientservice.Auth.exception.AccessDeniedException;
import clientservice.Client.model.Client;
import clientservice.Infra.session.ClientSession;
import org.springframework.stereotype.Service;
import productservice.Product.dto.create.CreateProductRequest;
import productservice.Product.dto.get.GetProductRequest;
import productservice.Product.dto.get.GetProductResponse;

import java.util.Optional;

@Service
public class ProductService {
    // Atributos
    private ClientSession clientSession;

    // Construtor
    public ProductService(ClientSession clientSession) {
        this.clientSession = clientSession;
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


        return new GetProductResponse("abababa", 2, 22, 5);
    }
}
