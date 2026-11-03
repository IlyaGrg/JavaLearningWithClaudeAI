package ru.ilyagrg.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.Optional;

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
}