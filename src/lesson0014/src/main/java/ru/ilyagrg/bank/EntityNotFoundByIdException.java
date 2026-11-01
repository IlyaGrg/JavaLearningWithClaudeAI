package lesson0014.src.main.java.ru.ilyagrg.bank;

public class EntityNotFoundByIdException extends RuntimeException {
    public EntityNotFoundByIdException(String message) {
        super(message);
    }
}