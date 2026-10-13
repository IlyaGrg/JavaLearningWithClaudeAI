package lesson0006;

public class TransferService {
    private Notifier notifier;

    public TransferService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void transfer(BankAccount from, BankAccount to, int amount) {
        try {
            from.transferTo(to, amount);
        } catch (IllegalArgumentException | WithdrawalLimitExceededException | InsufficientFundsException e) {
            notifier.send(from.getOwner(), "Ошибка перевода: " + e.getMessage());
            throw e;
        }
        notifier.send(from.getOwner(), "Списано " + amount + " руб.");
        notifier.send(to.getOwner(), "Зачислено " + amount + " руб.");
    }
}