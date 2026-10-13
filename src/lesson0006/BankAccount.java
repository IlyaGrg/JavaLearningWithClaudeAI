package lesson0006;


public class BankAccount implements Comparable<BankAccount> {
    private String owner;
    private int balance;

    public BankAccount(String owner, int balance) {
        checkOwner(owner);
        this.owner = owner;

        checkBalance(balance);
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма пополнения должна быть неотрицательной: " + amount);
        }
        balance = balance + amount;
    }

    public void withdraw(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма снятия не может быть отрицательной: " + amount);
        }
        if (amount > balance) {
            throw new InsufficientFundsException(amount, balance);
        }
        balance = balance - amount;
    }

    public void transferTo(BankAccount other, int amount) {
        if (other == this) {
            throw new IllegalArgumentException("Нельзя перевести деньги самому себе");
        }
        if (other == null) {
            throw new IllegalArgumentException("Нельзя перевести деньги несуществующему пользователю");
        }
        withdraw(amount);
        other.deposit(amount);
    }

    private static void checkOwner(String owner) {
        if (owner == null || owner.isBlank()) {
            throw new IllegalArgumentException("Имя владельца аккаунта не может быть пустым или состоять только из пробелов");
        }
    }

    private static void checkBalance(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Баланс на счету не может быть отрицательным: " + balance);
        }
    }

    @Override
    public String toString() {
        return owner + ": " + balance + " руб.";
    }

    @Override
    public int compareTo(BankAccount other){
        return Integer.compare(this.balance, other.balance);
    }
}