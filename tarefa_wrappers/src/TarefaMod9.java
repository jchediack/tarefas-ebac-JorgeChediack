// Exercicio Modulo 9
import java.util.Scanner;

public class TarefaMod9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe sua idade:");
        int idade = scanner.nextInt();    // Tipo Primitivo
        System.out.println("O valor em tipo primitivo é: " + idade);

        Integer idadeNew = (Integer) idade; // Casting
        System.out.println("O valor em tipo Wrapper é: " + idadeNew);

        scanner.close();
    }
}
