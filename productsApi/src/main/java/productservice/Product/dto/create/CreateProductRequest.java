package productservice.Product.dto.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record CreateProductRequest(
        @NotBlank(message = "O nome do produto é obrigatório")
        @Size(min = 1, message = "O nome do produto deve ter no mínimo 1 caracter")
        String name,

        @NotNull(message = "O preço do produto é obrigatório")
        @PositiveOrZero(message = "O preço do produto deve ser maior ou igual a 0")
        Double price
) {}
