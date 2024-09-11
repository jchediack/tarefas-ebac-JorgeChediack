import java.util.ArrayList;
import java.util.List;

public class TrocoGuloso {

    public static void main(String[] args) {
        // Exemplo de entrada
        int quantia = 18;
        int[] moedasDisponiveis = {5, 2, 1};

        // Calcula o menor número de moedas para dar o troco
        List<Integer> troco = calcularTroco(quantia, moedasDisponiveis);

        // Exibe o resultado
        System.out.println("Moedas usadas para o troco: " + troco);
        System.out.println("Número total de moedas: " + troco.size());
    }

    // Função que calcula o troco usando o algoritmo guloso
    public static List<Integer> calcularTroco(int quantia, int[] moedasDisponiveis) {
        List<Integer> resultado = new ArrayList<>();

        // Percorre o array de moedas disponíveis
        for (int moeda : moedasDisponiveis) {
            // Enquanto a moeda atual couber na quantia
            while (quantia >= moeda) {
                resultado.add(moeda); // Adiciona a moeda ao resultado
                quantia -= moeda; // Subtrai o valor da moeda da quantia
            }
        }

        return resultado;
    }
}
