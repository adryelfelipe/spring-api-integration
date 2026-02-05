package clientservice.Client.dto.get;

import jakarta.validation.constraints.PositiveOrZero;

public record GetClientRequest(@PositiveOrZero(message = "O id do cliente deve ser maior ou igual a 0") long id) {
}
