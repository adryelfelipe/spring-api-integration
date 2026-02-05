package client.dto.get;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record GetClientResponse(
        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "O email está inválido")
        String email
) {}
