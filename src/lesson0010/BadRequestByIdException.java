package lesson0010;

public class BadRequestByIdException extends RuntimeException {
    public BadRequestByIdException(String message) {
        super(message);
    }
}