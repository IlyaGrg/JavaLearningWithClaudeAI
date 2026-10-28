package lesson0013;

public class EntityNotFoundByIdException extends RuntimeException {
    public EntityNotFoundByIdException(String message) {
        super(message);
    }
}