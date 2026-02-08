package productservice.Auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record AuthenticateRequest(
        @NotBlank(message = "A senha para comunicação com a API é obrigatória")
        String password,

        @NotNull(message = "O id do cliente é obrigatório")
        @PositiveOrZero(message = "O id do cliente deve ser maior ou igual a 0")
        Long clientId) {
}
