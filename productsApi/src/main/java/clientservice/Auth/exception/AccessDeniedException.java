package clientservice.Auth.exception;

public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException() {
        super("Acess denied.");
    }
}
