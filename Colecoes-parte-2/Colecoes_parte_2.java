import java.util.Scanner;

public class Colecoes_parte_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int quantidade = 4; // Quantidade de Nomes
        String[] nomes = new String[quantidade];
        String[] sexo = new String[quantidade];
        String[] gMasculino = new String[quantidade];
        String[] gFeminino = new String[quantidade];

        for(int i = 0; i < quantidade; i++) {
            System.out.println("Informe um nome e sexo, separados por vírgula, por exemplo: Rodrigo,M");
            String resposta = s.next();
            nomes[i] = resposta.split(",")[0];
            sexo[i] = resposta.split(",")[1];
            System.out.println(" ");
            //System.out.println("Nome: " + nomes[i]);
            //System.out.println("Sexo: " + sexo[i]);

            if (sexo[i].equals("M")) {
                gMasculino[i] = nomes[i];
            } else if (sexo[i].equals("F")) {
                gFeminino[i] = nomes[i];
            } else {
                System.out.println("Sexo não identificado");
            }
        }
        System.out.println("Sexo Masculino");
        for(int i = 0; i < gMasculino.length; i++) {
            if (gMasculino[i] != null) {
                System.out.println(gMasculino[i]);
            }
        }
        System.out.println(" ");
        System.out.println("Sexo Feminino");
        for (int i = 0; i < gFeminino.length; i++) {
            if (gFeminino[i] != null) {
                System.out.println(gFeminino[i]);
            }
        }
    }
}
