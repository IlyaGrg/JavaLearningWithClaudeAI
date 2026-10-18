package lesson0008;


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