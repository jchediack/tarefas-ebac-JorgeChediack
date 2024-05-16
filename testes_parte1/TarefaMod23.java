package testJunit;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.assertTrue;

public class TarefaMod23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> pessoas = new ArrayList<>();
        System.out.println("Informe 4 nomes separados por vírgula:");
        System.out.println("Exemplo: Rodrigo,M");

        for (int i = 0; i < 4; i++) {
            String input = scanner.nextLine();
            pessoas.add(input);
        }
        List<String> mulheres = filtrarSexo(pessoas, "F");
        System.out.println("Pessoas do sexo feminino:");
        mulheres.forEach(System.out::println);
    }

    @Test
    public static List<String> filtrarSexo(List<String> pessoas, String sexo) {
        List<String> lista = pessoas.stream()
                .filter(p -> p.split(",")[1].equalsIgnoreCase(sexo))
                .toList();

    for (String pessoa : lista) {
        String[] partes = pessoa.split(",");
        assertTrue(partes.length == 2); // Verifique se há duas partes (nome e sexo)
        assertTrue(partes[1].equalsIgnoreCase("F")); // Verifique se o sexo é feminino
    }

    return lista;
    }
}