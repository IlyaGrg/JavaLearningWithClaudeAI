package lesson0010;

public class DuplicateAccountException extends RuntimeException{
    public DuplicateAccountException(String message){
        super(message);
    }
}