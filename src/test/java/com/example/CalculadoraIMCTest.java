package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraIMCTest {

    @Test
    void testCalcularIMC() {
        // Teste com um caso conhecido
        assertEquals(22.857, CalculadoraIMC.calcularIMC(70, 1.75), 0.001);
    }

    @Test
    void testCalcularIMCComAlturaZero() {
        // Teste de exceção para altura inválida
        assertThrows(IllegalArgumentException.class, () -> {
            CalculadoraIMC.calcularIMC(70, 0);
        });
    }

    @Test
    void testClassificarIMCAbaixoDoPeso() {
        assertEquals("Abaixo do peso", CalculadoraIMC.classificarIMC(18.4));
    }

    @Test
    void testClassificarIMCPesoNormal() {
        // Testando as bordas da categoria
        assertEquals("Peso normal", CalculadoraIMC.classificarIMC(18.5)); // Borda inferior
        assertEquals("Peso normal", CalculadoraIMC.classificarIMC(24.9)); // Borda superior
    }

    @Test
    void testClassificarIMCSobrepeso() {
        // Testando as bordas da categoria
        assertEquals("Sobrepeso", CalculadoraIMC.classificarIMC(25.0)); // Borda inferior
        assertEquals("Sobrepeso", CalculadoraIMC.classificarIMC(29.9)); // Borda superior
    }

    @Test
    void testClassificarIMCObesidade() {
        // Testando a borda inferior da categoria
        assertEquals("Obesidade", CalculadoraIMC.classificarIMC(30.0));
        assertEquals("Obesidade", CalculadoraIMC.classificarIMC(40.0)); // Caso bem definido como obesidade
    }
}