# 44_PSW_MarilynVilcapuma

Laboratorio de pruebas unitarias con JUnit 5 y Maven.

---

## Actividad: Método de Descuentos

### Objetivo

Probar un método que calcula el precio final de un producto después de aplicarle
un porcentaje de descuento, con un mínimo de 4 casos de prueba más un quinto
caso elegido y justificado.

### Método a probar

Ubicado en [Descuento.java](src/main/java/com/marilyn/testing/Descuento.java):

```java
public double calcularPrecioFinal(double precio, double descuento) {
    return precio - (precio * descuento / 100);
}
```

### Casos de prueba

Implementados en [DescuentoTest.java](src/test/java/com/marilyn/testing/DescuentoTest.java):

| # | Precio | Descuento | Esperado | Por qué decidimos probarlo |
|---|--------|-----------|----------|----------------------------|
| 1 | 100 | 10% | 90 | Es el uso normal del método: verifica que la fórmula funcione en la situación más común |
| 2 | 200 | 20% | 160 | Cambia precio y descuento a la vez, para confirmar que el resultado no dependía de los números del caso anterior |
| 3 | 50 | 0% | 50 | Un producto sin promoción debe conservar su precio: el método no debe alterar nada cuando no hay descuento |
| 4 | 500 | 50% | 250 | Resultado fácil de verificar mentalmente (la mitad), sirve como control de que el cálculo es correcto |
| 5 | 300 | 100% | 0 | **Caso propio.**|

---

## ¿Por qué elegimos el quinto caso?

**Caso 5: precio 300 con un descuento del 100% → el precio final debe ser 0.**

Decidimos probar este caso por tres razones:

**1. Los cuatro casos sugeridos dejaban un vacío.**
El caso 3 (0%) cubre el valor más bajo que puede tomar un descuento, pero
ninguno de los otros llega al valor más alto. Sin este caso, la prueba solo
confirma que el método funciona con descuentos parciales.

**2. Los errores aparecen en los extremos, no en el medio.**
Repetir un descuento intermedio más (15%, 30%, 25%) habría dado un test que se
comporta igual que los anteriores y aporta poca información nueva. Probar el
tope del rango sí revela algo que aún no sabíamos del método.

**3. Es un resultado que el negocio debe garantizar.**
Un descuento del 100% significa que el producto queda gratis: el precio final
tiene que ser exactamente 0. Si el método devolviera un número negativo, el
sistema estaría cobrando "al revés". Este caso deja esa regla escrita y
verificada, no asumida.

**Qué protege en el futuro:** si alguien modifica la fórmula por error y olvida
dividir entre 100, el resultado de este caso pasaría de 0 a −29700 y la prueba
fallaría de inmediato. Los otros cuatro casos también fallarían, pero es en este
donde el error se vuelve más evidente.

---

## Estructura del proyecto

```
src/
├── main/java/com/marilyn/testing/
│   ├── Calificacion.java      Promedio de notas y estado de aprobación
│   ├── Descuento.java         Cálculo de precio final con descuento
│   ├── Producto.java          Cálculo de total por cantidad
│   └── Main.java
└── test/java/com/marilyn/testing/
    ├── CalificacionTest.java  8 casos de prueba
    ├── DescuentoTest.java     5 casos de prueba
    └── ProductoTest.java      1 caso de prueba
```

## Ejecución de las pruebas

Todas las pruebas del proyecto:

```bash
mvn test
```

Solo las pruebas de descuentos:

```bash
mvn test -Dtest=DescuentoTest
```

Resultado obtenido con `mvn test`:

```
Tests run: 14, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```
