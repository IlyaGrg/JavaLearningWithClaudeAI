package lesson0009;

public class BadRequestByIdException extends RuntimeException {
    public BadRequestByIdException(String message) {
        super(message);
    }
}