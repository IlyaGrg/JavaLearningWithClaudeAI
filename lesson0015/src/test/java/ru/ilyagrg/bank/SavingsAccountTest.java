package ru.ilyagrg.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class SavingsAccountTest {
    private SavingsAccount savingsAccount;
    @BeforeEach
    void setUp(){
        savingsAccount = new SavingsAccount("ilya", 100_000, 50, 50_000);
    }

    @Test
    void checkConstructor(){
        assertThrows(IllegalArgumentException.class, () -> new SavingsAccount("Ilya", 1, 101, 2));
        assertThrows(IllegalArgumentException.class, () -> new SavingsAccount("Ilya", 1, -2, 2));
        assertThrows(IllegalArgumentException.class, () -> new SavingsAccount("Ilya", 1, 50, -100));
    }

    @Test
    void checkWithdrawLimit(){
        savingsAccount.withdraw(50_000);
        assertEquals(savingsAccount.getBalance(), 50_000);
    }

    @Test
    void checkWithdrawMoreThanLimit(){
        WithdrawalLimitExceededException e = assertThrows(WithdrawalLimitExceededException.class,
                () -> savingsAccount.withdraw(50_001));
        assertTrue(e.getAmount() > e.getMaxWithdrawal());
        assertEquals(savingsAccount.getBalance(), 100_000);
    }

    @Test
    void checkAddInterest(){
        savingsAccount.addInterest();
        assertEquals(100_000 + (100_000 * 50) / 100, savingsAccount.getBalance());
    }
}