package lesson0007;

public class WithdrawalLimitExceededException extends RuntimeException {
    private int amount;
    private int maxWithdrawal;

    public WithdrawalLimitExceededException(int amount, int maxWithdrawal) {
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