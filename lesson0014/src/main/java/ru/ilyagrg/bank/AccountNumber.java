package ru.ilyagrg.bank;

import org.apache.commons.lang3.StringUtils;

public record AccountNumber(String value) {
    public AccountNumber{
        if (StringUtils.isBlank(value)|| !value.startsWith("BANK")) {
            throw new IllegalArgumentException("Некорректное значение: ");
        }
    }
}
//Была 41 строка стало 11