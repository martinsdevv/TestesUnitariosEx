package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversorTemperaturaTest {

    private static final double DELTA = 0.001;

    @Test
    void testCelsiusParaFahrenheit() {
        // Caso normal: Ponto de congelamento da água
        assertEquals(32.0, ConversorTemperatura.celsiusParaFahrenheit(0), DELTA);
        // Caso normal: Ponto de ebulição da água
        assertEquals(212.0, ConversorTemperatura.celsiusParaFahrenheit(100), DELTA);
        // Caso de borda: Onde as escalas se cruzam
        assertEquals(-40.0, ConversorTemperatura.celsiusParaFahrenheit(-40), DELTA);
        // Caso com valor positivo
        assertEquals(68.0, ConversorTemperatura.celsiusParaFahrenheit(20), DELTA);
    }

    @Test
    void testFahrenheitParaCelsius() {
        // Caso normal: Ponto de congelamento da água
        assertEquals(0.0, ConversorTemperatura.fahrenheitParaCelsius(32), DELTA);
        // Caso normal: Ponto de ebulição da água
        assertEquals(100.0, ConversorTemperatura.fahrenheitParaCelsius(212), DELTA);
        // Caso de borda: Onde as escalas se cruzam
        assertEquals(-40.0, ConversorTemperatura.fahrenheitParaCelsius(-40), DELTA);
        // Caso que resulta em decimal
        assertEquals(10.0, ConversorTemperatura.fahrenheitParaCelsius(50), DELTA);
    }
}