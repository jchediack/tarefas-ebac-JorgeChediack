import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private final Calculadora calculadora = new Calculadora();

    @Test
    void testAdicionar() {
        assertEquals(5, calculadora.testarAdicionar(2, 3));
        assertEquals(0, calculadora.testarAdicionar(-2, 2));
    }

    @Test
    void testSubtrair() {
        assertEquals(1, calculadora.testarSubtrair(3, 2));
        assertEquals(-4, calculadora.testarSubtrair(-2, 2));
    }

    @Test
    void testMultiplicar() {
        assertEquals(6, calculadora.testarMultiplicar(2, 3));
        assertEquals(0, calculadora.testarMultiplicar(0, 5));
    }

    @Test
    void testDividir() {
        assertEquals(2, calculadora.testarDividir(6, 3));
        assertEquals(-3, calculadora.testarDividir(-9, 3));
    }

    @Test
    void testDividirPorZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculadora.testarDividir(5, 0);
        });
        assertEquals("Divisão por zero não é permitida", exception.getMessage());
    }
}