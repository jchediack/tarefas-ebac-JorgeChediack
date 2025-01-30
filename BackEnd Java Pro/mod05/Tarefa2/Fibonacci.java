import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void testFindElementDP() {
        // Teste para verificar os primeiros números da sequência
        assertEquals(0, Fibonacci.findElementDP(0)); // F(0) = 0
        assertEquals(1, Fibonacci.findElementDP(1)); // F(1) = 1
        assertEquals(1, Fibonacci.findElementDP(2)); // F(2) = 1
        assertEquals(2, Fibonacci.findElementDP(3)); // F(3) = 2
        assertEquals(3, Fibonacci.findElementDP(4)); // F(4) = 3
        assertEquals(5, Fibonacci.findElementDP(5)); // F(5) = 5
    }

    @Test
    void testLargeElement() {
        // Teste para verificar números grandes da sequência
        assertEquals(832040, Fibonacci.findElementDP(30)); // F(30) = 832040
        assertEquals(1346269, Fibonacci.findElementDP(31)); // F(31) = 1346269
    }

    @Test
    void testInvalidInput() {
        // Teste para entrada inválida
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Fibonacci.findElementDP(101); // Acima do limite definido de 100
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    void testNegativeInput() {
        // Teste para verificar comportamento com números negativos
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Fibonacci.findElementDP(-1);
        });
        assertNotNull(exception.getMessage());
    }
}