/**
 * Exercício Modulo 7
 *
 */
public class Livro {

    // Método principal para testar a classe
    public static void main(String[] args) {
        Livro meuLivro = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1178);
        meuLivro.exibirInformacoes();
    }
    // Propriedades
    private String titulo;
    private String autor;
    private int numPaginas;

    // Construtor
    public Livro(String titulo, String autor, int numPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    // Método para exibir informações sobre o livro
    public void exibirInformacoes() {
        System.out.println("Livro: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Número de Páginas: " + numPaginas);
    }
}

