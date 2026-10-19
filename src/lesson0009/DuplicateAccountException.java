package lesson0009;

public class DuplicateAccountException extends RuntimeException{
    public DuplicateAccountException(String message){
        super(message);
    }
}