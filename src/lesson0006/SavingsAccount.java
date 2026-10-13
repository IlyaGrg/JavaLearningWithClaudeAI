package lesson0006;

public class SavingsAccount extends BankAccount {
    private int interestRate;
    private int maxWithdrawal;

    public SavingsAccount(String owner, int balance, int interestRate, int maxWithdrawal) {

        super(owner, balance);
        if (interestRate < 0 || interestRate > 100) {
            throw new IllegalArgumentException("Процент начисления должен быть от 0 до 100: " + interestRate);
        }
        if (maxWithdrawal <= 0) {
            throw new IllegalArgumentException("Максимум должен быть положительным: " + maxWithdrawal);
        }

        this.interestRate = interestRate;
        this.maxWithdrawal = maxWithdrawal;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public int getMaxWithdrawal() {
        return maxWithdrawal;
    }

    public void addInterest() {
        this.deposit(getBalance() * interestRate / 100);
    }

    //src/lesson0005/SavingsAccount.java:42: error: method does not override or implement a method from a supertype
//    @Override
//    ^
//1 error
    //Ошибка из-за того, что не понятно зачем стоит @Override если не находися такого же метода в классе родителе
//Лимит изменился потому что применяется родительская версия метода withdraw(), а withdrow в этотм момент никто не вызывал, следовательно лимита нет
    @Override
    public void withdraw(int amount) {

        if (amount > maxWithdrawal) {
            throw new WithdrawalLimitExceededException(amount, maxWithdrawal);
        }
        super.withdraw(amount);
    }

    @Override
    public String toString() {
        return super.toString() + " Накопительный счет, " + interestRate + "%";
    }
}