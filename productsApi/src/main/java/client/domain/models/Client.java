package client.domain.models;

public class Client {
    // Atributos
    private String name;
    private String password;
    private String email;

    // Construtor
    public Client(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
