package productservice.Product.dto.get;

import clientservice.Client.dto.get.GetClientResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record GetProductResponse(String name, Long product_id, Double price, GetClientResponse client) {
}
