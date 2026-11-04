package ru.ilyagrg.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount("Ilya", 123_456);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " "})
    void checkConstructorWithIllegalOwner(String str) {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(str, 123_000));
    }

    @Test
    void checkConstructorWithIllegalBalance() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount("User", -123));
    }

    @Test
    void checkDeposit() {
        bankAccount.deposit(100_000);
        assertEquals(bankAccount.getBalance(), 123_456 + 100_000);
    }

    @Test
    void checkWithdraw() {
        bankAccount.withdraw(23_456);
        assertEquals(bankAccount.getBalance(), 123_456 - 23_456);
    }

    @Test
    void checkWithdrawWithALotOfMoney(){
        InsufficientFundsException e = assertThrows(InsufficientFundsException.class,
        () -> bankAccount.withdraw(1_000_000));
        assertEquals(e.getAvailable(), bankAccount.getBalance());
    }

    @Test
    void checkIllegalDeposit() {
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-1));
    }

    @Test
    void checkIllegalWithdrawWithNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(-1));
    }

    @Test
    void checkIllegalWithdrawWithAmountBiggerThanBalance() {
        InsufficientFundsException e = assertThrows(
                InsufficientFundsException.class,
                () -> bankAccount.withdraw(1_000_000)
        );
        assertEquals(e.getAvailable(), 123_456);
    }

    @Test
    void checkBorderOfWithdraw() {
        bankAccount.withdraw(123_456);
        assertEquals(bankAccount.getBalance(), 0);
    }

    @Test
    void checkTransferTo() {
        BankAccount secondAccount = new BankAccount("Valeria", 123_000);
        bankAccount.transferTo(secondAccount, 100_000);
        assertEquals(secondAccount.getBalance(), 123_000 + 100_000);
        assertEquals(bankAccount.getBalance(), 123_456 - 100_000);
    }

    @Test
    void checkTransferToWithNoMoney(){
        BankAccount secondAccount = new BankAccount("Valeria", 123_000);
        InsufficientFundsException e = assertThrows(InsufficientFundsException.class,
                () -> secondAccount.transferTo(bankAccount, 125_000));
        assertEquals(e.getAvailable(), secondAccount.getBalance());
        assertEquals(123_456, bankAccount.getBalance());
    }

    @Test
    void checkTransferToYourSelfAndNull(){
        assertThrows(IllegalArgumentException.class, () -> bankAccount.transferTo(bankAccount, 10_000));
        assertThrows(IllegalArgumentException.class, () -> bankAccount.transferTo(null, 10_000));
        assertEquals(123_456, bankAccount.getBalance());
    }
}