package ru.ilyagrg.bank;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CollectionUtilsTest {
    @Test
    void checkFirstOrThrow(){
        List<Integer> emptyList = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> CollectionUtils.firstOrThrow(emptyList));
        List<Integer> list = List.of(100, 2, 3);
        assertEquals(100, CollectionUtils.firstOrThrow(list));
    }

    @Test
    void checkMax(){
        List<Integer> emptyList = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> CollectionUtils.max(emptyList));
        List<Integer> list = List.of(23, 100, 2, 3);
        assertEquals(100, CollectionUtils.max(list));
        List<String> strList = List.of("apple", "sex", "zero");
        assertEquals("zero", CollectionUtils.max(strList));
    }
}