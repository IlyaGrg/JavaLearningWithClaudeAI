package lesson0014.src.main.java.ru.ilyagrg.bank;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}