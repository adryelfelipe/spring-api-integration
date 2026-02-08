package clientservice.Auth.exception;

public class AccessDeniedException extends AuthException {
    public AccessDeniedException() {
        super("Acesso negado");
    }
}
