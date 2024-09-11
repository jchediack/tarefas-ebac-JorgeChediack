import java.util.ArrayList;
import java.util.List;

public class Backtracking {

    public static void main(String[] args) {
        // Exemplo de entrada
        int[] S = {1, 2, 3, 4}; // Conjunto de elementos únicos
        int n = 2; // Tamanho dos subconjuntos

        // Calcula todos os subconjuntos de tamanho n
        List<List<Integer>> resultado = gerarSubconjuntos(S, n);

        // Exibe os subconjuntos
        for (List<Integer> subconjunto : resultado) {
            System.out.println(subconjunto);
        }
    }

    // Função principal que gera os subconjuntos de tamanho n
    public static List<List<Integer>> gerarSubconjuntos(int[] S, int n) {
        List<List<Integer>> resultado = new ArrayList<>();
        List<Integer> atual = new ArrayList<>();
        backtrack(S, n, 0, atual, resultado);
        return resultado;
    }

    // Função de backtracking para gerar subconjuntos
    private static void backtrack(int[] S, int n, int inicio, List<Integer> atual, List<List<Integer>> resultado) {
        // Condição base: se o subconjunto atual tiver tamanho n, adiciona ao resultado
        if (atual.size() == n) {
            resultado.add(new ArrayList<>(atual));
            return;
        }

        // Itera sobre os elementos do conjunto S
        for (int i = inicio; i < S.length; i++) {
            atual.add(S[i]); // Adiciona o elemento atual
            backtrack(S, n, i + 1, atual, resultado); // Chamada recursiva com o próximo elemento
            atual.remove(atual.size() - 1); // Remove o último elemento para tentar uma nova combinação
        }
    }
}
