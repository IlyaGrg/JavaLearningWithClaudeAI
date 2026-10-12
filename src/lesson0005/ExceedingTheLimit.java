package lesson0005;

public class ExceedingTheLimit extends RuntimeException {
    private int amount;
    private int maxWithdrawal;

    public ExceedingTheLimit(int amount, int maxWithdrawal) {
        super("Нельзя снять сумму " + amount + " это превышает лимит в " + maxWithdrawal);
        this.amount = amount;
        this.maxWithdrawal = maxWithdrawal;
    }

    public int getAmount() {
        return amount;
    }

    public int getMaxWithdrawal() {
        return maxWithdrawal;
    }
}