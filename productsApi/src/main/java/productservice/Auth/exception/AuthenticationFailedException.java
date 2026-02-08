package productservice.Auth.exception;

public class AuthenticationFailedException extends AuthException {
    public AuthenticationFailedException() {
        super("Não foi possível autenticar");
    }
}
