package client.dto.get;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record GetClientResponse(
         @NotBlank
         String name,

         @Email
         @NotBlank
         String email,

         long id
) {}
