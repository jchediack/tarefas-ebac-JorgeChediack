/**
 * Classe Calculadora que fornece operações matemáticas básicas.
 */
public class Calculadora {

    /**
     * Adiciona dois números inteiros.
     * @param a Primeiro número.
     * @param b Segundo número.
     * @return A soma de a e b.
     */
    private int adicionar(int a, int b) {
        return a + b;
    }

    /**
     * Subtrai dois números inteiros.
     * @param a Primeiro número.
     * @param b Segundo número.
     * @return A diferença entre a e b.
     */
    private int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dois números inteiros.
     * @param a Primeiro número.
     * @param b Segundo número.
     * @return O produto de a e b.
     */
    private int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide dois números inteiros.
     * @param a Primeiro número (dividendo).
     * @param b Segundo número (divisor).
     * @return O quociente da divisão de a por b.
     * @throws ArithmeticException se b for zero.
     */
    private int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida");
        }
        return a / b;
    }

    /**
     * Método público para testar a adição.
     * @param a Primeiro número.
     * @param b Segundo número.
     * @return Resultado da soma de a e b.
     */
    public int testarAdicionar(int a, int b) {
        return adicionar(a, b);
    }

    /**
     * Método público para testar a subtração.
     * @param a Primeiro número.
     * @param b Segundo número.
     * @return Resultado da subtração de a por b.
     */
    public int testarSubtrair(int a, int b) {
        return subtrair(a, b);
    }

    /**
     * Método público para testar a multiplicação.
     * @param a Primeiro número.
     * @param b Segundo número.
     * @return Resultado da multiplicação de a por b.
     */
    public int testarMultiplicar(int a, int b) {
        return multiplicar(a, b);
    }

    /**
     * Método público para testar a divisão.
     * @param a Primeiro número.
     * @param b Segundo número.
     * @return Resultado da divisão de a por b.
     * @throws ArithmeticException se b for zero.
     */
    public int testarDividir(int a, int b) {
        return dividir(a, b);
    }
}
