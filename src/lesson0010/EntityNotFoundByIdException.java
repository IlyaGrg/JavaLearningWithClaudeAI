package lesson0010;

public class EntityNotFoundByIdException extends RuntimeException {
    public EntityNotFoundByIdException(String message) {
        super(message);
    }
}