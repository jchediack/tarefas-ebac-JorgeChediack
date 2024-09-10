import java.math.BigInteger;

public class Fatorial {

    public static BigInteger fatorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 150; // Exemplo de número maior que 100
        System.out.println("Fatorial de " + num + " é: " + fatorial(num));
    }
}
