package client.dto.get;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record GetClientResponse(
        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "O email está inválido")
        String email,

        @PositiveOrZero(message = "O id do cliente deve ser maior ou igual a 0")
        long id
) {}
