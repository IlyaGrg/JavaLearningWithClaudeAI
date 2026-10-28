package lesson0013;

public class DuplicateAccountException extends RuntimeException{
    public DuplicateAccountException(String message){
        super(message);
    }
}