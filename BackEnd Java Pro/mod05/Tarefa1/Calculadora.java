public class Calculadora {

    private int adicionar(int a, int b) {
        return a + b;
    }

    private int subtrair(int a, int b) {
        return a - b;
    }

    private int multiplicar(int a, int b) {
        return a * b;
    }

    private int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida");
        }
        return a / b;
    }

    // Métodos públicos para teste
    public int testarAdicionar(int a, int b) {
        return adicionar(a, b);
    }

    public int testarSubtrair(int a, int b) {
        return subtrair(a, b);
    }

    public int testarMultiplicar(int a, int b) {
        return multiplicar(a, b);
    }

    public int testarDividir(int a, int b) {
        return dividir(a, b);
    }
}
