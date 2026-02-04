package product.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import product.dto.CreateProductRequest;
import product.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    // Atributos
    private ProductService productService;

    // Construtor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Métodos
    @PostMapping()
    public ResponseEntity<Void> save(@RequestBody @Valid CreateProductRequest request) {
        productService.save(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }
}
