package lesson0007;

import java.util.Map;

public class Bank {
    private Map<String, BankAccount> accounts;

    public Bank(Map<String, BankAccount> accounts) {
        if (accounts == null) {
            throw new IllegalArgumentException("Некорректный ввод данных");
        }
        this.accounts = accounts;
    }

    public void openAccount(String number, BankAccount account) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("Некорректный номер");
        }
        if (accounts.get(number) != null) {
            throw new AccountEndeedException("Такой номер счета уже существует: " + number);
        }
        accounts.put(number, account);
    }

    BankAccount findAccount(String number) {
        checkingNumber(number);
        return accounts.get(number);
    }


    public void transfer(String fromNumber, String toNumber, int amount) {
        checkingNumber(fromNumber);
        checkingNumber(toNumber);
        accounts.get(fromNumber).transferTo(accounts.get(toNumber), amount);
    }

    public int totalBalance() {
        int totalSum = 0;
        for (Map.Entry<String, BankAccount> e : accounts.entrySet()) {
            totalSum += (e.getValue()).getBalance();
        }
        return totalSum;
    }

    public void checkingNumber(String number) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("Некорректный номер");
        }
        if (accounts.get(number) == null) {
            throw new BadAccessFromNumberException("Не удается найти данный номер: " + number);
        }
    }

}