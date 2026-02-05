package product.model;

import client.model.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 2, max = 199, message = "O nome deve ter entre 2 e 199 caracteres")
    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @NotNull(message = "O preço é obrigatório")
    @Column(name = "price", nullable = false)
    private Double price;

    // Relacionamento com Client
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "client_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_product_client")
    )
    private Client client;


    public Product() {
    }


    public Product(String name, Double price, Client client) {
        this.name = name;
        this.price = price;
        this.client = client;
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

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
}