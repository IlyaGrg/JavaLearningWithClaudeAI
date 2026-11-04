package ru.ilyagrg.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.ValueSource;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class InMemoryRepositoryTest {
    private InMemoryRepository<String, String> inMemoryRepository;

    @BeforeEach
    void setUp() {
        inMemoryRepository = new InMemoryRepository<>();
        inMemoryRepository.save("1", "first");
        inMemoryRepository.save("2", "second");
        inMemoryRepository.save("3", "third");
    }

    @Test
    void checkTest(){
        InMemoryRepository<String, Integer> I = new InMemoryRepository<>();
        assertThrows(IllegalArgumentException.class, () -> I.save(null, "item"));
        assertThrows(IllegalArgumentException.class, () -> I.save(1, null));
    }

    @Test
    void checkFindByIdWithNormalArgument() {
        assertEquals(Optional.of("first"), inMemoryRepository.findById("1"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"4", "", " "})
    void checkFindByIdWithBadArgument(String str) {
        assertTrue(inMemoryRepository.findById(str).isEmpty());
    }

    @Test
    void checkExistById() {
        assertTrue(inMemoryRepository.existsById("1"));
        assertFalse(inMemoryRepository.existsById("первый"));
    }

    @Test
    void checkCount() {
        InMemoryRepository<String, String> I = new InMemoryRepository<>();
        assertEquals(inMemoryRepository.count(), 3);
        assertEquals(I.count(), 0);
    }

    @Test
    void checkFindAll() {
        InMemoryRepository<String, String> I = new InMemoryRepository<>();
        assertEquals(List.of("first", "second", "third"), inMemoryRepository.findAll().stream().sorted().toList());
        assertEquals(I.findAll(), List.of());
    }

    @Test
    void checkDeleteById() {
        inMemoryRepository.deleteById("1");
        assertFalse(inMemoryRepository.existsById("1"));
        assertThrows(EntityNotFoundByIdException.class, () -> inMemoryRepository.deleteById("1"));
        assertThrows(IllegalArgumentException.class, () -> inMemoryRepository.deleteById(null));
    }

    @Test
    void checkFindByIdWithNullArgument(){
        assertThrows(IllegalArgumentException.class, () -> inMemoryRepository.findById(null));
    }


}