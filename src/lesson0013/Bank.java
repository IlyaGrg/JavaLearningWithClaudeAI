package lesson0013;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        return accounts.findById(number).orElseThrow(() -> new AccountNotFoundException("Аккаунт не найден: " + number));
    }

    public void transfer(AccountNumber fromNumber, AccountNumber toNumber, int amount) {
        checkNumber(fromNumber);
        checkNumber(toNumber);
        findAccount(fromNumber).transferTo(findAccount(toNumber), amount);
    }

    public int totalBalance() {
        return accounts.findAll().stream().mapToInt(BankAccount::getBalance).sum();
    }

    private void checkNumber(AccountNumber number) {
        if (number == null) {
            throw new IllegalArgumentException("Некорректное значение: " + number);
        }

    }

    public List<String> owners() {
        return accounts.findAll().stream().map(BankAccount::getOwner).distinct().sorted().toList();
    }

    public Map<String, Integer> balanceByOwner() {
        return accounts.findAll().stream().collect(Collectors.groupingBy(BankAccount::getOwner, Collectors.summingInt(BankAccount::getBalance)));
    }

    public Map<String, List<BankAccount>> accountsByOwner() {
        return accounts.findAll().stream().collect(Collectors.groupingBy(BankAccount::getOwner));
    }

    public int getCount() {
        return accounts.count();
    }

    public void deleteUser(AccountNumber number) {
        accounts.deleteById(number);
    }

    public List<BankAccount> sortedByOwner(){
        return accounts.findAll().stream().sorted(Comparator.comparing(BankAccount::getOwner).thenComparingInt(BankAccount::getBalance)).toList();
    }
    public List<BankAccount> sortedByBalanceDesc(){
        return accounts.findAll().stream().sorted(Comparator.comparing(BankAccount::getBalance).reversed()).toList();
    }

    public List<BankAccount> findAccounts(Predicate<BankAccount> filter){
        return accounts.findAll().stream().filter(filter).toList();
    }

    public List<String> richOwners(int minBalance){
        return accounts.findAll().stream().sorted(Comparator.comparing(BankAccount::getOwner)).filter(acc -> acc.getBalance() >= minBalance).map(BankAccount::getOwner).distinct().toList();
    }

    public long countAccounts(Predicate<BankAccount> filter){
        return accounts.findAll().stream().filter(filter).map(BankAccount::getBalance).count();
    }
}