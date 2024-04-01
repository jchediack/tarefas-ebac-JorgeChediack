package tarefa13;

public abstract class Pessoa {

    private String nome;
    private String endereco;
    public abstract String getIdentificacao(); //Metodo abstrato
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
