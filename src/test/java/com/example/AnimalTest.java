package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    Animal animal = new Animal();

    @Test
    void getFoodReturnsHerbivoreFood() throws Exception {
        assertEquals(List.of("Трава", "Различные растения"), animal.getFood("Травоядное"));
    }

    @Test
    void getFoodReturnsCarnivoreFood() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), animal.getFood("Хищник"));
    }

    @Test
    void getFoodThrowsExceptionForUnknownAnimalKind() {
        Exception exception = assertThrows(Exception.class, () -> animal.getFood("Unknown"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    void getFamilyReturnsCorrectFamily() {
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }
}
