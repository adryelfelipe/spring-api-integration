package client.dto.get;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record GetClientResponse(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 2, max = 199, message = "O nome deve ter entre 2 e 199 caracteres")
        String name,

        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "Formato de e-mail inválido")
        @Size(max = 254, message = "O e-mail não pode exceder 254 caracteres")
        String email,

        @PositiveOrZero(message = "O id do cliente deve ser maior ou igual a 0")
        long id
) {}
