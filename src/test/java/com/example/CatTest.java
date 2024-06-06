package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    @Mock
    Feline feline;

    Cat cat;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cat = new Cat(feline);
    }

    @Test
    void getSoundReturnsMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodReturnsPredatorFood() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(food);
        assertEquals(food, cat.getFood());
    }
}
