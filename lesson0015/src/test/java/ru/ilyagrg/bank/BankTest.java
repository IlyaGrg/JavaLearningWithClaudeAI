package ru.ilyagrg.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;

public class BankTest {
    private Bank bank;
    private AccountNumber accountNumber;
    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        accountNumber = new AccountNumber("BANK-4117");
        bankAccount = new BankAccount("Ilya", 123_000);
        bank.openAccount(accountNumber, bankAccount);
    }

    @Test
    void checkOpenAccount() {
        AccountNumber n = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Ilya", 1);
        assertThrows(IllegalArgumentException.class, () -> bank.openAccount(null, bankAccount));
        assertThrows(IllegalArgumentException.class, () -> bank.openAccount(n, null));
        assertThrows(DuplicateAccountException.class, () -> bank.openAccount(accountNumber, b));
    }

    @Test
    void checkDeleteUser() {
        bank.deleteUser(accountNumber);
        assertFalse(bank.existById(accountNumber));
        assertThrows(IllegalArgumentException.class, () -> bank.deleteUser(null));
        assertThrows(EntityNotFoundByIdException.class, () -> bank.deleteUser(accountNumber));
    }

    @Test
    void checkFindAccount() {
        AccountNumber n = new AccountNumber("BANK-4117");
        assertSame(bank.findAccount(n), bankAccount);
        assertThrows(AccountNotFoundException.class, () -> bank.findAccount(new AccountNumber("BANK-1111")));
    }

    @Test
    void CheckTransfer() {
        AccountNumber n = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Valeria", 123_000);
        bank.openAccount(n, b);
        bank.transfer(n, accountNumber, 123_000);
        assertEquals(0, b.getBalance());
        assertEquals(123_000 + 123_000, bankAccount.getBalance());
    }

    @Test
    void checkTransferWithBadNumber() {
        assertThrows(AccountNotFoundException.class, () -> bank.transfer(new AccountNumber("BANK-1234"), accountNumber, 1));
        assertThrows(AccountNotFoundException.class, () -> bank.transfer(accountNumber, new AccountNumber("BANK-1234"), 1));
    }

    @Test
    void checkTotalBalance() {
        AccountNumber n = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Valeria", 123_000);
        bank.openAccount(n, b);
        assertEquals(b.getBalance() + bankAccount.getBalance(), bank.totalBalance());
        Bank newBank = new Bank();
        assertEquals(0, newBank.totalBalance());
    }

    @Test
    void checkOwners() {
        AccountNumber n = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Adam", 123_000);
        AccountNumber accountNumber1 = new AccountNumber("BANK-4111");
        SavingsAccount bankAccount1 = new SavingsAccount("Ilya", 123_000, 20, 40_000);
        bank.openAccount(n, b);
        bank.openAccount(accountNumber1, bankAccount1);
        assertEquals(List.of("Adam", "Ilya"), bank.owners());
        Bank newBank = new Bank();
        assertTrue(newBank.owners().isEmpty());
    }

    @Test
    void checkBalanceByOwner() {
        AccountNumber n = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Adam", 123_000);
        AccountNumber accountNumber1 = new AccountNumber("BANK-4111");
        SavingsAccount bankAccount1 = new SavingsAccount("Ilya", 123_000, 20, 40_000);
        Map<String, Integer> map = new HashMap<>();
        map.put("Ilya", bankAccount.getBalance() + bankAccount1.getBalance());
        map.put("Adam", b.getBalance());
        bank.openAccount(n, b);
        bank.openAccount(accountNumber1, bankAccount1);
        assertEquals(map, bank.balanceByOwner());
        Bank newBank = new Bank();
        assertTrue(newBank.balanceByOwner().isEmpty());
    }

    @Test
    void checkAccountsByOwner() {
        AccountNumber n = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Adam", 123_000);
        AccountNumber accountNumber1 = new AccountNumber("BANK-4111");
        SavingsAccount bankAccount1 = new SavingsAccount("Ilya", 100_000, 20, 40_000);
        bank.openAccount(n, b);
        bank.openAccount(accountNumber1, bankAccount1);
        Map<String, List<BankAccount>> map = bank.accountsByOwner();
        assertEquals(Set.of("Adam", "Ilya"), map.keySet());
        assertEquals(List.of(b), map.get("Adam"));
        assertEquals(2, map.get("Ilya").size());
        assertEquals(Set.of(bankAccount1, bankAccount), new HashSet<>(map.get("Ilya")));
        Bank newBank = new Bank();
        assertTrue(newBank.accountsByOwner().isEmpty());
    }

    @Test
    void checkSortedByOwner() {
        BankAccount bankAccount2 = new BankAccount("Valeria", 123_000);
        AccountNumber n = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Adam", 123_000);
        AccountNumber accountNumber1 = new AccountNumber("BANK-4111");
        SavingsAccount bankAccount1 = new SavingsAccount("Ilya", 100_000, 20, 40_000);
        AccountNumber accountNumber2 = new AccountNumber("BANK-V");
        bank.openAccount(n, b);
        bank.openAccount(accountNumber1, bankAccount1);
        bank.openAccount(accountNumber2, bankAccount2);
        assertEquals(List.of(b, bankAccount1, bankAccount, bankAccount2), bank.sortedByOwner());
    }

    @Test
    void checkSortedByBalanceDesc() {
        BankAccount bankAccount2 = new BankAccount("Valeria", 123);
        AccountNumber n = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Adam", 123_000_000);
        AccountNumber accountNumber1 = new AccountNumber("BANK-4111");
        SavingsAccount bankAccount1 = new SavingsAccount("Ilya", 100_000, 20, 40_000);
        AccountNumber accountNumber2 = new AccountNumber("BANK-V");
        bank.openAccount(n, b);
        bank.openAccount(accountNumber1, bankAccount1);
        bank.openAccount(accountNumber2, bankAccount2);
        assertEquals(List.of(b, bankAccount, bankAccount1, bankAccount2), bank.sortedByBalanceDesc());
    }

    @Test
    void checkFindAccounts() {
        BankAccount bankAccount2 = new BankAccount("Valeria", 123);
        AccountNumber n = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Adam", 1_000_000);
        AccountNumber accountNumber1 = new AccountNumber("BANK-4111");
        SavingsAccount bankAccount1 = new SavingsAccount("Ilya", 100_000, 20, 40_000);
        AccountNumber accountNumber2 = new AccountNumber("BANK-V");
        bank.openAccount(n, b);
        bank.openAccount(accountNumber1, bankAccount1);
        bank.openAccount(accountNumber2, bankAccount2);
        assertEquals(List.of(b), bank.findAccounts(acc -> acc.getBalance() > 500_000));
        assertTrue(bank.findAccounts(acc -> acc.getBalance() > 1_100_000).isEmpty());
        assertEquals(List.of(bankAccount1, bankAccount), bank.findAccounts(acc -> acc.getOwner().equals("Ilya")).stream().sorted(Comparator.comparing(BankAccount::getBalance)).toList());
        assertTrue(bank.findAccounts(acc -> acc.getOwner().equals("Admin")).isEmpty());
    }

    @Test
    void checkCountAccounts() {
        BankAccount bankAccount2 = new BankAccount("Valeria", 123);
        AccountNumber n = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Adam", 1_000_000);
        AccountNumber accountNumber1 = new AccountNumber("BANK-4111");
        SavingsAccount bankAccount1 = new SavingsAccount("Ilya", 100_000, 20, 40_000);
        AccountNumber accountNumber2 = new AccountNumber("BANK-V");
        bank.openAccount(n, b);
        bank.openAccount(accountNumber1, bankAccount1);
        bank.openAccount(accountNumber2, bankAccount2);
        assertEquals(2, bank.countAccounts(acc -> acc.getBalance() > 110_000));
        assertEquals(0, bank.countAccounts(acc -> acc.getBalance() > 1_100_000));
        assertEquals(2, bank.countAccounts(acc -> acc.getOwner().equals("Ilya")));
        assertEquals(0, bank.countAccounts(acc -> acc.getOwner().equals("Ilyas")));
    }

    @Test
    void checkRichOwners() {
        BankAccount bankAccount2 = new BankAccount("Valeria", 123);
        AccountNumber n = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Adam", 1_000_000);
        AccountNumber accountNumber1 = new AccountNumber("BANK-4111");
        SavingsAccount bankAccount1 = new SavingsAccount("Ilya", 100_000, 20, 40_000);
        AccountNumber accountNumber2 = new AccountNumber("BANK-V");
        bank.openAccount(n, b);
        bank.openAccount(accountNumber1, bankAccount1);
        bank.openAccount(accountNumber2, bankAccount2);
        assertEquals(List.of("Adam", "Ilya"), bank.richOwners(100_000));
        assertEquals(List.of("Adam", "Ilya"), bank.richOwners(123_000));
        assertTrue(bank.richOwners(2_000_000).isEmpty());
    }

    @Test
    void checkFindRichest() {
        BankAccount bankAccount2 = new BankAccount("Valeria", 123);
        AccountNumber n = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Adam", 1_000_000);
        AccountNumber accountNumber1 = new AccountNumber("BANK-4111");
        SavingsAccount bankAccount1 = new SavingsAccount("Ilya", 100_000, 20, 40_000);
        AccountNumber accountNumber2 = new AccountNumber("BANK-V");
        bank.openAccount(n, b);
        bank.openAccount(accountNumber1, bankAccount1);
        bank.openAccount(accountNumber2, bankAccount2);
        assertEquals(Optional.of(b), bank.findRichest());
        Bank newBank = new Bank();
        assertTrue(newBank.findRichest().isEmpty());
    }


}