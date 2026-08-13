package com.marilyn.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DescuentoTest {

    private static final double TOLERANCIA = 0.0001;

    private Descuento descuento;

    @BeforeEach
    void setUp() {
        descuento = new Descuento();
    }

    @Test
    @DisplayName("Caso 1: precio 100 con 10% -> 90")
    void debeAplicarDescuentoDel10() {

        double resultado = descuento.calcularPrecioFinal(100, 10);

        assertEquals(90, resultado, TOLERANCIA);
    }

    @Test
    @DisplayName("Caso 2: precio 200 con 20% -> 160")
    void debeAplicarDescuentoDel20() {

        double resultado = descuento.calcularPrecioFinal(200, 20);

        assertEquals(160, resultado, TOLERANCIA);
    }

    @Test
    @DisplayName("Caso 3: precio 50 con 0% -> 50")
    void debeMantenerElPrecioSinDescuento() {

        double resultado = descuento.calcularPrecioFinal(50, 0);

        assertEquals(50, resultado, TOLERANCIA);
    }

    @Test
    @DisplayName("Caso 4: precio 500 con 50% -> 250")
    void debeAplicarDescuentoDel50() {

        double resultado = descuento.calcularPrecioFinal(500, 50);

        assertEquals(250, resultado, TOLERANCIA);
    }

    // Caso propio: 100% es el limite superior valido; el precio final debe ser
    // exactamente 0 y nunca un valor negativo.
    @Test
    @DisplayName("Caso 5 (elegido): precio 300 con 100% -> 0")
    void debeQuedarEnCeroConDescuentoTotal() {

        double resultado = descuento.calcularPrecioFinal(300, 100);

        assertEquals(0, resultado, TOLERANCIA);
    }
}
