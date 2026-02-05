package clientservice.Client.exception;

public class ClientNotFoundException extends ClientException {
    public ClientNotFoundException(String email) {
        super("Cliente não encontrado com o email: " + email);
    }
}
