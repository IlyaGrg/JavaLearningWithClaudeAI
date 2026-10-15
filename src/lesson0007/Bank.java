package lesson0007;

import java.util.*;

public class Bank {
    //Bank должен создавать Map сам для того, чтобы нельзя было его поменять из другой части кода в обход всем проверкам. Нужно чтобы ссылки на Map не было.
    private Map<String, BankAccount> accounts = new HashMap<>();


    public void openAccount(String number, BankAccount account) {
        if (account == null) {
            throw new IllegalArgumentException("Банк не моежт открыть аккаунт для этого счета");
        }
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("Некорректный номер");
        }
        if (accounts.containsKey(number) && accounts.get(number) != null) {
            throw new DuplicateAccountException("Такой номер счета уже существует: " + number);
        }

        accounts.put(number, account);
    }

    public BankAccount findAccount(String number) {
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
        for (BankAccount user : accounts.values()) {
            totalSum += user.getBalance();
        }
        return totalSum;
    }

    private void checkingNumber(String number) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("Некорректный номер");
        }
        if (accounts.get(number) == null) {
            throw new AccountNotFoundException("Не удается найти данный номер: " + number);
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