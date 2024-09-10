import java.util.HashMap;

public class FatorialTopDown {
    private static HashMap<Integer, Long> memo = new HashMap<>();

    public static long fatorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        long result = n * fatorial(n - 1);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        int num = 7; // Exemplo de entrada
        System.out.println("Fatorial de " + num + " é: " + fatorial(num));
    }
}
