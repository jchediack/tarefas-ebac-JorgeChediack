import java.math.BigInteger;

public class FatorialBottomUp {
    public static BigInteger fatorial(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1].multiply(BigInteger.valueOf(i));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int num = 150; // Exemplo de número maior que 100
        System.out.println("Fatorial de " + num + " é: " + fatorial(num));
    }
}
