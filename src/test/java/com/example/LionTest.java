package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LionTest {

    @Mock
    Feline feline;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void lionHasManeBasedOnSex(String sex, boolean hasMane) throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(hasMane, lion.doesHaveMane());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Invalid", "123", ""})
    void throwsExceptionWhenInvalidSex(String sex) {
        Exception exception = assertThrows(Exception.class, () -> new Lion(sex, feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void getKittensReturnsCorrectValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(3);
        assertEquals(3, lion.getKittens());
    }

    @Test
    void getFoodReturnsCorrectList() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(food);
        assertEquals(food, lion.getFood());
    }
}
