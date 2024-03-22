import java.util.*;

public class tarefa_colecao {
    public static void main(String[] args) {
        parte1();
        System.out.println(" ");
        parte2();
    }
    private static void parte1() {
        Scanner s = new Scanner(System.in);
        System.out.println("Informe varios nomes separados por virgula: ");
        List<String> listaNomes = new ArrayList<String>();
        String resposta = s.nextLine();
        listaNomes.addAll(Arrays.asList(resposta.split(",")));
        System.out.println("Lista de nomes em Ordem Alfabética: ");
        Collections.sort(listaNomes);
        System.out.println(listaNomes);
    }
    private static void parte2 () {
        Scanner s2 = new Scanner(System.in);
        List<String> listaSexoMasculino = new ArrayList<String>();
        List<String> listaSexoFeminino = new ArrayList<String>();
        List<String> listaNome = new ArrayList<String>();

        System.out.println("Informe quatro Nomes e Sexo. Exemplo: Rodrigo-M ");
        for(int i = 0; i < 4; i++) {
            System.out.println("Informe o Nome-Sexo: ");
            String resposta2 = s2.nextLine();
            listaNome.addAll(Arrays.asList(resposta2.split("-")));

            if(listaNome.getLast().equalsIgnoreCase("M")) {
                //System.out.println("Masculino");
                listaNome.removeLast();
                listaSexoMasculino.add(listaNome.getLast());
            } else if (listaNome.getLast().equalsIgnoreCase("F")) {
                //System.out.println("Feminino");
                listaNome.removeLast();
                listaSexoFeminino.add(listaNome.getLast());
            } else {
                System.out.println("Sexo Indefinido");
                listaNome.removeLast();
            }
        }
        System.out.println(" ");
        System.out.println("Grupo Masculino: ");
        System.out.println(listaSexoMasculino);
        System.out.println(" ");
        System.out.println("Grupo Feminino: ");
        System.out.println(listaSexoFeminino);
    }
}