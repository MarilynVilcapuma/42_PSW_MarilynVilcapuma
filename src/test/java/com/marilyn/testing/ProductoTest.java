package com.marilyn.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductoTest {

    @Test
    void debeCalcularTotalCorrectamente() {

        // Arrange - Preparamos el producto
        Producto producto = new Producto("Laptop", 50);

        // Act - Ejecutamos calcularTotal(3)
        double resultado = producto.calcularTotal(3);

        // Assert - Verificamos el total esperado
        assertEquals(150, resultado);
    }
}
