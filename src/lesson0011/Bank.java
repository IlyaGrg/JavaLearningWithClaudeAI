package lesson0011;

import java.util.*;

public class Bank {
    private Repository<BankAccount, AccountNumber> accounts = new InMemoryRepository<>();

    public void openAccount(AccountNumber number, BankAccount account) {
        checkNumber(number);
        if (account == null) {
            throw new IllegalArgumentException("Невозможно создать аккаунт для такого пользователя: " + account);
        }
        if (accounts.existsById(number)) {
            throw new DuplicateAccountException("Такой номер счета уже существует: " + number);
        }

        accounts.save(number, account);
    }

    public BankAccount findAccount(AccountNumber number) {
        return accounts.findById(number);
    }

    public void transfer(AccountNumber fromNumber, AccountNumber toNumber, int amount) {
        checkNumber(fromNumber);
        checkNumber(toNumber);
        findAccount(fromNumber).transferTo(findAccount(toNumber), amount);
    }

    public int totalBalance() {
        int totalSum = 0;
        for (BankAccount user : accounts.findAll()) {
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
        for (BankAccount user : accounts.findAll()) {
            owner.add(user.getOwner());
        }
        return owner;
    }

    public Map<String, Integer> balanceByOwner() {
        Map<String, Integer> balanceAndOwner = new HashMap<>();
        for (BankAccount user : accounts.findAll()) {
            String owner = user.getOwner();
            balanceAndOwner.merge(owner, user.getBalance(), Integer::sum);
        }
        return balanceAndOwner;
    }

    public Map<String, List<BankAccount>> accountsByOwner() {
        Map<String, List<BankAccount>> userAccounts = new HashMap<>();
        for (BankAccount user : accounts.findAll()) {
            userAccounts.computeIfAbsent(user.getOwner(), k -> new ArrayList<>()).add(user);
        }

        return userAccounts;
    }

    public int getCount() {
        return accounts.count();
    }

    public void deleteUser(AccountNumber number) {
        accounts.deleteById(number);
    }

}