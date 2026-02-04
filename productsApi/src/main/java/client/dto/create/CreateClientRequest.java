package client.dto.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateClientRequest(
        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
        String password,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "O email está inválido")
        String email
) {}
