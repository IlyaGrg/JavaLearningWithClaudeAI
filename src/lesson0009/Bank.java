package lesson0009;

import java.util.*;

public class Bank {
    //Bank должен создавать Map сам для того, чтобы нельзя было его поменять из другой части кода в обход всем проверкам. Нужно чтобы ссылки на Map не было.
    private Map<AccountNumber, BankAccount> accounts = new HashMap<>();


    public void openAccount(AccountNumber number, BankAccount account) {
        checkNumber(number);
        if (account == null) {
            throw new IllegalArgumentException("Невозможно создать аккаунт для такого пользователя: " + account);
        }
        if (accounts.containsKey(number)) {
            throw new DuplicateAccountException("Такой номер счета уже существует: " + number);
        }

        accounts.put(number, account);
    }

    public BankAccount findAccount(AccountNumber number) {
        checkNumber(number);
        if (accounts.get(number) == null) {
            throw new AccountNotFoundException("Аккаунт не найден: " + number.getValue());
        }
        return accounts.get(number);
    }


    public void transfer(AccountNumber fromNumber, AccountNumber toNumber, int amount) {
        checkNumber(fromNumber);
        checkNumber(toNumber);
        findAccount(fromNumber).transferTo(findAccount(toNumber), amount);
    }

    public int totalBalance() {
        int totalSum = 0;
        for (BankAccount user : accounts.values()) {
            totalSum += user.getBalance();
        }
        return totalSum;
    }

    private void checkNumber(AccountNumber number) {
        if (number == null) {
            throw new IllegalArgumentException("Некорректное значение: " + number);
        }

    }

    public Set<String> owners() {
        Set<String> owner = new HashSet<>();
        for (BankAccount user : accounts.values()) {
            owner.add(user.getOwner());
        }
        return owner;
    }

    public Map<String, Integer> balanceByOwner() {
        Map<String, Integer> balanceAndOwner = new HashMap<>();
        for (BankAccount user : accounts.values()) {
            String owner = user.getOwner();
            balanceAndOwner.put(owner, balanceAndOwner.getOrDefault(owner, 0) + user.getBalance());
        }
        return balanceAndOwner;
    }

    public Map<String, List<BankAccount>> accountsByOwner() {
        Map<String, List<BankAccount>> userAccounts = new HashMap<>();
        for (BankAccount user : accounts.values()) {
            String owner = user.getOwner();
            List<BankAccount> ownerAccounts = userAccounts.get(owner);
            if (ownerAccounts == null) {
                ownerAccounts = new ArrayList<>();
                userAccounts.put(owner, ownerAccounts);
            }
            ownerAccounts.add(user);
        }

        return userAccounts;
    }

}