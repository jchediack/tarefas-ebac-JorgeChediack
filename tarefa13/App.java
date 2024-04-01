package tarefa13;

public class App {
    public static void main(String [] args) {
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setNome("Jeff Henrique");
        pessoaFisica.setCpf("022.561.875-64");
        pessoaFisica.setEndereco("Rua X");

        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setNome("Empresa S/A");
        pessoaJuridica.setCnpj("17.145.985-0001/01");
        pessoaJuridica.setEndereco("Avenida Y");

        System.out.println("************************");
        System.out.println("Dados Pessoa Fisica: " + pessoaFisica.getNome());
        System.out.println(pessoaFisica.getEndereco());
        System.out.println(pessoaFisica.getIdentificacao());
        System.out.println(" ");
        System.out.println("************************");
        System.out.println("Dados Pessoa Juridica: " + pessoaJuridica.getNome());
        System.out.println(pessoaJuridica.getEndereco());
        System.out.println(pessoaJuridica.getIdentificacao());
    }
}