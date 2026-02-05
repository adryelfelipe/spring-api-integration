package client.dto.get;

import jakarta.validation.constraints.PositiveOrZero;

public record GetClientRequest(@PositiveOrZero long id) {
}
