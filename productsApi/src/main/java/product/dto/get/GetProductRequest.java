package product.dto.get;

import jakarta.validation.constraints.PositiveOrZero;

public record GetProductRequest(@PositiveOrZero(message = "O id do produto deve ser maior ou igual a 0") long id) {
}
