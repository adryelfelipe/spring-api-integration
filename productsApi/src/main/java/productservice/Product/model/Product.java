package productservice.Product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 2, max = 200, message = "O nome deve ter entre 2 e 200 caracteres")
    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @NotNull(message = "O preço é obrigatório")
    @Column(name = "price", nullable = false)
    private Double price;

    @Column(nullable = false)
    private Long clientId;

    // Construtor vazio para JPA
    public Product() {
    }

    // Construtor
    public Product(Long id, String name, Double price, Long clientId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.clientId = clientId;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}