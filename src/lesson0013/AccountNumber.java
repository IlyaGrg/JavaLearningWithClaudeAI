package lesson0013;

import java.util.Objects;

public record AccountNumber(String value) {
    public AccountNumber{
        if (value == null || value.isBlank() || !value.startsWith("BANK")) {
            throw new IllegalArgumentException("Некорректное значение: ");
        }
    }
}
//Была 41 строка стало 11