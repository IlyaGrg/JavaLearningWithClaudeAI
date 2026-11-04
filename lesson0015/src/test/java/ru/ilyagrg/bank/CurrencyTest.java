package ru.ilyagrg.bank;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;





import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CurrencyTest {
    @ParameterizedTest
    @CsvSource({
            "USD, $",
            "RUB, ₽",
            "EUR, €"
    })
    void checkSymbolCurrency(Currency c, String sym) {
        assertEquals(c.symbol(), sym);
    }

    @ParameterizedTest
    @CsvSource({
            "USD, Доллар США",
            "RUB, Российский рубль",
            "EUR, Евро"
    })
    void checkDisplayName(Currency c, String str) {
        assertEquals(c.getDisplayName(), str);
    }

    @ParameterizedTest
    @CsvSource({
            "USD, USD",
            "RUB, RUB",
            "EUR, EUR"
    })
    void checkEntity(Currency c, String str) {
        assertEquals(Currency.valueOf(str), c);
    }

    @Test
    void exceptionInIllegalCurrency() {
        assertThrows(IllegalArgumentException.class, () -> Currency.valueOf("YPN"));
    }

}