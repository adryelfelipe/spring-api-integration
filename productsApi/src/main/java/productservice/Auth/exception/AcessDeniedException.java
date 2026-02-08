package productservice.Auth.exception;

public class AcessDeniedException extends AuthException {
    public AcessDeniedException() {
        super("Acesso negado");
    }
}
