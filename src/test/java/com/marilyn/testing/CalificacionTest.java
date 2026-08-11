package com.marilyn.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalificacionTest {

    /** Tolerancia para comparar decimales (evita errores de punto flotante). */
    private static final double TOLERANCIA = 0.0001;

    private Calificacion calificacion;

    @BeforeEach
    void setUp() {
        // JUnit ejecuta este metodo antes de CADA test, con una instancia nueva.
        calificacion = new Calificacion();
    }

    // ==========================================================
    // 1. Probar calcularPromedio()
    // ==========================================================

    @Test
    @DisplayName("Caso 1: notas 15, 14, 16 -> promedio 15")
    void debeCalcularPromedioDeNotas15_14_16() {

        // Act - Ejecutamos calcularPromedio(15, 14, 16)
        double resultado = calificacion.calcularPromedio(15, 14, 16);

        // Assert - Verificamos el promedio esperado
        assertEquals(15, resultado, TOLERANCIA);
    }

    @Test
    @DisplayName("Caso 2: notas 10, 12, 14 -> promedio 12")
    void debeCalcularPromedioDeNotas10_12_14() {

        // Act
        double resultado = calificacion.calcularPromedio(10, 12, 14);

        // Assert
        assertEquals(12, resultado, TOLERANCIA);
    }

    @Test
    @DisplayName("Caso 3: notas 20, 18, 16 -> promedio 18")
    void debeCalcularPromedioDeNotas20_18_16() {

        // Act
        double resultado = calificacion.calcularPromedio(20, 18, 16);

        // Assert
        assertEquals(18, resultado, TOLERANCIA);
    }

    // ==========================================================
    // 2. Probar estaAprobado()
    // ==========================================================

    @Test
    @DisplayName("Caso 4: promedio 15 -> true")
    void debeAprobarConPromedio15() {

        // Act
        boolean resultado = calificacion.estaAprobado(15);

        // Assert
        assertTrue(resultado);
    }

    @Test
    @DisplayName("Caso 5: promedio 13 -> true (limite)")
    void debeAprobarConPromedio13EnElLimite() {

        // Act
        boolean resultado = calificacion.estaAprobado(13);

        // Assert
        assertTrue(resultado);
    }

    @Test
    @DisplayName("Caso 6: promedio 12 -> false")
    void debeDesaprobarConPromedio12() {

        // Act
        boolean resultado = calificacion.estaAprobado(12);

        // Assert
        assertFalse(resultado);
    }

    @Test
    @DisplayName("Caso 7: promedio 05 -> false")
    void debeDesaprobarConPromedio05() {

        // Act
        boolean resultado = calificacion.estaAprobado(5);

        // Assert
        assertFalse(resultado);
    }

    // ==========================================================
    // RETO: octavo caso de prueba
    //
    // Justificacion:
    // Los casos 1 al 7 prueban cada metodo por separado y siempre con
    // promedios "redondos". El caso 8 encadena los dos metodos: calcula el
    // promedio de 12, 13 y 14 y usa ese resultado como entrada de
    // estaAprobado(). Aporta dos cosas que ningun caso anterior cubre:
    //
    //   a) Verifica que ambos metodos funcionan juntos, no solo aislados.
    //   b) Llega al limite de 13 a traves de una division real (39 / 3) y no
    //      con un valor escrito a mano, que es como ocurre en el uso real de
    //      la clase.
    // ==========================================================

    @Test
    @DisplayName("Caso 8 (reto): notas 12, 13, 14 -> promedio 13 -> aprobado true")
    void debeAprobarCuandoElPromedioCalculadoLlegaAlLimite() {

        // Act
        double promedio = calificacion.calcularPromedio(12, 13, 14);
        boolean resultado = calificacion.estaAprobado(promedio);

        // Assert
        assertEquals(13, promedio, TOLERANCIA);
        assertTrue(resultado);
    }
}
