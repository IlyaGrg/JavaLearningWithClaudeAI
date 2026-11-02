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
public class AccountNumberTest {
    private AccountNumber accountNumber;

    @BeforeEach
    void setUp(){
        accountNumber = new AccountNumber("BANK-4117");
    }
    @Test
    void checkValue(){
        assertEquals(accountNumber.value(), "BANK-4117");
    }
    @Test
    void checkSameNumbers(){
        assertEquals(accountNumber, new AccountNumber("BANK-4117"));
    }
    @Test
    void checkHashCode(){
        assertEquals(accountNumber.hashCode(), new AccountNumber("BANK-4117").hashCode());
    }
    @Test
    void checkEqualsOfDifferenceNumber(){
        assertTrue(!accountNumber.equals(new AccountNumber("BANK-1234")));
    }
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "BANT-1234"})
    void checkIllegalValue(String str){
        assertThrows(IllegalArgumentException.class, () -> new AccountNumber(str));
    }

}