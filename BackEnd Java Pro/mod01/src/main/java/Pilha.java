import java.util.ArrayList;


public class Pilha {

    private ArrayList<Integer> elementos;

    public Pilha() {

        this.elementos = new ArrayList<>();

    }

    public void push(int valor) {

        elementos.add(valor);

    }

    public int pop() {

        if (isEmpty()) {

            throw new IllegalStateException("A pilha está vazia");

        }

        return elementos.remove(elementos.size() - 1);

    }

    public int top() {

        if (isEmpty()) {

            throw new IllegalStateException("A pilha está vazia");

        }

        return elementos.get(elementos.size() - 1);

    }

    public boolean isEmpty() {

        return elementos.isEmpty();

    }

    public int size() {

        return elementos.size();

    }

    public static void main(String[] args) {

        Pilha pilha = new Pilha();

        // Teste

        pilha.push(10);

        pilha.push(20);

        pilha.push(30);

        System.out.println("Topo da pilha: " + pilha.top()); // Saída: 30

        System.out.println("Tamanho da pilha: " + pilha.size()); // Saída: 3

        System.out.println("Removido: " + pilha.pop()); // Saída: 30

        System.out.println("Topo da pilha: " + pilha.top()); // Saída: 20

        System.out.println("A pilha está vazia? " + pilha.isEmpty()); // Saída: false

    }
}