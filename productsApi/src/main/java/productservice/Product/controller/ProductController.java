package productservice.Product.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productservice.Product.dto.create.CreateProductRequest;
import productservice.Product.dto.get.GetProductRequest;
import productservice.Product.dto.get.GetProductResponse;
import productservice.Product.services.ProductService;

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
    public ResponseEntity<Void> create(@RequestBody @Valid CreateProductRequest request) {
        productService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductResponse> get(@Valid GetProductRequest request) {
        GetProductResponse response = productService.get(request);

        return ResponseEntity.ok(response);
    }
}
