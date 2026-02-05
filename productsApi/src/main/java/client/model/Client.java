package client.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 2, max = 199, message = "O nome deve ter entre 2 e 199 caracteres")
    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    @Size(max = 254, message = "O e-mail não pode exceder 254 caracteres")
    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;


    public Client() {
    }

    public Client(String name, String email, Long id) {
        this.name = name;
        this.email = email;
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
