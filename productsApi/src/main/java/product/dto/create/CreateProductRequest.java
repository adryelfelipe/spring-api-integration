package product.dto.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record CreateProductRequest(
        @NotBlank
        @Size(min = 1)
        String name,

        @Positive long id,

        @PositiveOrZero double price
) {}
