import java.util.Scanner;
public class tarefa_controleFluxo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a primeira nota:");
        double nota1 = scanner.nextDouble();
        System.out.println("Digite a segunda nota:");
        double nota2 = scanner.nextDouble();
        System.out.println("Digite a terceira nota:");
        double nota3 = scanner.nextDouble();
        System.out.println("Digite a quarta nota:");
        double nota4 = scanner.nextDouble();
        double totalNota = (nota1 + nota2 + nota3 + nota4) / 4;

        if (totalNota >= 7){
            System.out.println("Aluno APROVADO");
        } else if (totalNota >= 5) {
            System.out.println("Aluno em RECUPERAÇÃO");
        } else {
            System.out.println("Aluno REPROVADO");
        }
        scanner.close();
    }
}
