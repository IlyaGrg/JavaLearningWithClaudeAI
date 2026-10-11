package lesson0004;

//При Exception ошибка: src/lesson0004/BankAccount.java:35: error: unreported exception InsufficientFundsException; must be caught or declared to be thrown
//            throw new InsufficientFundsException(amount, balance);
//            ^
//1 error
//При добавлении throws src/lesson0004/BankAccount.java:35: error: illegal start of expression
//            throws new InsufficientFundsException(amount, balance);
//            ^
//1 error
public class InsufficientFundsException extends RuntimeException {
    private int requested;
    private int available;

    public InsufficientFundsException(int requested, int available) {
        super("Недостаточно средств, запрошено: " + String.valueOf(requested) + ", доступно: " + String.valueOf(available));
        this.requested = requested;
        this.available = available;
    }

    public int getRequested() {
        return requested;
    }

    public int getAvailable() {
        return available;
    }
}