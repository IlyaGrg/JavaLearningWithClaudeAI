package lesson0007;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public Set<String> owners() {
        Set<String> owner = new HashSet<>();
        for (Map.Entry<String, BankAccount> e : accounts.entrySet()) {
            owner.add(e.getValue().getOwner());
        }
        return owner;
    }

    public Map<String, Integer> balanceByOwner() {
        Map<String, Integer> balanceAndOwner = new HashMap<>();
        for (String owner : this.owners()) {
            int balance = 0;
            for (Map.Entry<String, BankAccount> e : accounts.entrySet()) {
                if (e.getValue().getOwner().equals(owner)){
                    balance += e.getValue().getBalance();
                    balanceAndOwner.put(owner, balance);
                }
            }
        }
        return balanceAndOwner;
    }

}