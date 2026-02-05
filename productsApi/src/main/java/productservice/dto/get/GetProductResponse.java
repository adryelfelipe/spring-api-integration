package productservice.dto.get;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record GetProductResponse(
        @NotBlank(message = "O nome do produto é obrigatório")
        @Size(min = 2, max = 199, message = "O nome deve ter entre 2 e 199 caracteres")
        String name,

        @PositiveOrZero(message = "O id do produto deve ser maior ou igual a 0")
        long id,

        @PositiveOrZero(message = "O preço do produto deve ser maior ou igual a 0")
        double price,

        @PositiveOrZero(message = "O id do cliente deve ser maior ou igual a 0")
        long clientId
) {}
