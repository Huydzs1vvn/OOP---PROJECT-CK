package exceptions;

public class AttemptExpiredException extends RuntimeException {
    public AttemptExpiredException(String message) {
        super(message);
    }
}
