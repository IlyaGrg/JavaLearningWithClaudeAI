package lesson0014.src.main.java.ru.ilyagrg.bank;

public class DuplicateAccountException extends RuntimeException{
    public DuplicateAccountException(String message){
        super(message);
    }
}