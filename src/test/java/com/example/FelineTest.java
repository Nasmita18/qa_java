package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    Feline feline = new Feline();

    @Test
    void eatMeatReturnsCarnivoreFood() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    void getFamilyReturnsCatFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensWithoutArgumentsReturnsOne() {
        assertEquals(1, feline.getKittens());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void getKittensWithArgumentsReturnsCorrectValue(int kittensCount) {
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
