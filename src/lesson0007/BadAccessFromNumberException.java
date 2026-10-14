package lesson0007;

public class BadAccessFromNumberException extends RuntimeException {
    public BadAccessFromNumberException(String message) {
        super(message);
    }
}