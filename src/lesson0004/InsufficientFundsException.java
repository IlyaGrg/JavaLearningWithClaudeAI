package lesson0004;

//При Exception ошибка: src/lesson0004/BankAccount.java:35: error: unreported exception InsufficientFundsException; must be caught or declared to be thrown
//            throw new InsufficientFundsException(amount, balance);
//            ^
//1 error
//При добавлении throws src/lesson0004/BankAccount.java:50: error: unreported exception InsufficientFundsException; must be caught or declared to be thrown
//        withdraw(amount);
//                ^
//1 error
//uncheked выбираем,потому что пришлось бы во всех местах менять сигнатуру
public class InsufficientFundsException extends RuntimeException {
    private int requested;
    private int available;

    public InsufficientFundsException(int requested, int available) {
        super("Недостаточно средств, запрошено: " + requested + ", доступно: " + available);
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