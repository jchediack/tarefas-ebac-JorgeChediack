package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tarefa_Streams {
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

    public static List<String> filtrarSexo(List<String> pessoas, String sexo) {
        return pessoas.stream()
                .filter(p -> p.split(",")[1].equalsIgnoreCase(sexo))
                .toList();
    }
}
