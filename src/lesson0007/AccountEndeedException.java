package lesson0007;

public class AccountEndeedException extends RuntimeException{
    public AccountEndeedException(String message){
        super(message);
    }
}