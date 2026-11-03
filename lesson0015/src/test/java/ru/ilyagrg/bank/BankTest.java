package ru.ilyagrg.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    void setUp(){
        bank = new Bank();
        accountNumber = new AccountNumber("BANK-4117");
        bankAccount = new BankAccount("Ilya", 123_000);
        bank.openAccount(accountNumber, bankAccount);
    }

    @Test
    void checkOpenAccount(){
        AccountNumber n  = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Ilya", 1);
        assertThrows(IllegalArgumentException.class, () -> bank.openAccount(null, bankAccount));
        assertThrows(IllegalArgumentException.class, () -> bank.openAccount(n, null));
        assertThrows(DuplicateAccountException.class, () -> bank.openAccount(accountNumber, b));
    }

    @Test
    void checkFindAccount(){
        AccountNumber n = new AccountNumber("BANK-4117");
        assertSame(bank.findAccount(n), bankAccount);
        assertThrows(AccountNotFoundException.class, () -> bank.findAccount(new AccountNumber("BANK-1111")));
    }

    @Test
    void CheckTransfer(){
        AccountNumber n = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Valeria", 123_000);
        bank.openAccount(n, b);
        bank.transfer(n, accountNumber, 123_000);
        assertEquals(b.getBalance(), 0);
        assertEquals(bankAccount.getBalance(), 123_000 + 123_000);
    }

    @Test
    void checkTransferWithBadNumber(){
        assertThrows(AccountNotFoundException.class, () -> bank.transfer(new AccountNumber("BANK-1234"), accountNumber, 1));
        assertThrows(AccountNotFoundException.class, () -> bank.transfer(accountNumber, new AccountNumber("BANK-1234"), 1));
    }

    @Test
    void checkTotalBalance(){
        AccountNumber n = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Valeria", 123_000);
        bank.openAccount(n, b);
        assertEquals(bank.totalBalance(), b.getBalance() + bankAccount.getBalance());
        Bank newBank = new Bank();
        assertEquals(newBank.totalBalance(), 0);
    }

    @Test
    void checkOwners(){
        AccountNumber n = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Adam", 123_000);
        AccountNumber accountNumber1 = new AccountNumber("BANK-4111");
        SavingsAccount bankAccount1 = new SavingsAccount("Ilya", 123_000, 20, 40_000);
        bank.openAccount(n, b);
        bank.openAccount(accountNumber1, bankAccount1);
        assertEquals(bank.owners(), List.of("Adam", "Ilya"));
    }

    @Test
    void checkBalanceByOwner(){
        AccountNumber n = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Adam", 123_000);
        AccountNumber accountNumber1 = new AccountNumber("BANK-4111");
        SavingsAccount bankAccount1 = new SavingsAccount("Ilya", 123_000, 20, 40_000);
        Map<String, Integer> map = new HashMap<>();
        map.put("Ilya", bankAccount.getBalance() + bankAccount1.getBalance());
        map.put("Adam", b.getBalance());
        bank.openAccount(n, b);
        bank.openAccount(accountNumber1, bankAccount1);
        assertEquals(bank.balanceByOwner(), map);
        Bank newBank = new Bank();
        assertTrue(newBank.balanceByOwner().isEmpty());
    }

    @Test
    void checkAccountsByOwner(){
        AccountNumber n = new AccountNumber("BANK-4110");
        BankAccount b = new BankAccount("Adam", 123_000);
        AccountNumber accountNumber1 = new AccountNumber("BANK-4111");
        SavingsAccount bankAccount1 = new SavingsAccount("Ilya", 100_000, 20, 40_000);
        Map<String, List<BankAccount>> map = new HashMap<>();
        map.put("Adam", List.of(b));
        map.put("Ilya", List.of(bankAccount, bankAccount1));
        bank.openAccount(n, b);
        bank.openAccount(accountNumber1, bankAccount1);
        assertEquals(bank.accountsByOwner(), map);
        Bank newBank = new Bank();
        assertTrue(newBank.balanceByOwner().isEmpty());
    }
}