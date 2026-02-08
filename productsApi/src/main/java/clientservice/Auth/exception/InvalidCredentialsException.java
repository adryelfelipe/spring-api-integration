package clientservice.Auth.exception;

public class InvalidCredentialsException extends AuthException {
    public InvalidCredentialsException() {
        super("Email ou senha estão inválidos");
    }
}
