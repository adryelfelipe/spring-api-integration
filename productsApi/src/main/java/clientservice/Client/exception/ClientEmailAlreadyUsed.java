package clientservice.Client.exception;

public class ClientEmailAlreadyUsed extends ClientException {
    public ClientEmailAlreadyUsed(String email) {
        super("O email já foi utilizado: " + email);
    }
}
