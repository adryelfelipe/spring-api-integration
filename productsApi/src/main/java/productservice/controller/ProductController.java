package productservice.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productservice.dto.create.CreateProductRequest;
import productservice.dto.get.GetProductRequest;
import productservice.dto.get.GetProductResponse;
import productservice.services.ProductService;

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

    @GetMapping("/{id}")
    public ResponseEntity<GetProductResponse> get(@Valid GetProductRequest request) {
        GetProductResponse response = productService.get(request);

        return ResponseEntity.ok(response);
    }
}
