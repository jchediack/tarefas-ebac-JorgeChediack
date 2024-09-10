import java.util.LinkedList;
import java.util.Queue;

public class Fila {

    private Queue<Integer> elementos;

    public Fila() {

        this.elementos = new LinkedList<>();

    }

    public void enqueue(int valor) {

        elementos.add(valor);

    }

    public int dequeue() {

        if (isEmpty()) {

            throw new IllegalStateException("A fila está vazia");

        }

        return elementos.poll(); // Remove o primeiro elemento

    }

    public int rear() {

        if (isEmpty()) {

            throw new IllegalStateException("A fila está vazia");

        }

        return (int) elementos.toArray()[elementos.size() - 1]; // Último elemento

    }

    public int front() {

        if (isEmpty()) {

            throw new IllegalStateException("A fila está vazia");

        }

        return elementos.peek(); // Primeiro elemento

    }

    public boolean isEmpty() {

        return elementos.isEmpty();

    }

    public int size() {

        return elementos.size();

    }

    public static void main(String[] args) {

        Fila fila = new Fila();

        // Teste

        fila.enqueue(10);

        fila.enqueue(20);

        fila.enqueue(30);

        System.out.println("Elemento na frente da fila: " + fila.front()); // Saída: 10

        System.out.println("Elemento no fim da fila: " + fila.rear()); // Saída: 30

        System.out.println("Tamanho da fila: " + fila.size()); // Saída: 3

        System.out.println("Removido da fila: " + fila.dequeue()); // Saída: 10

        System.out.println("Elemento na frente da fila: " + fila.front()); // Saída: 20

        System.out.println("A fila está vazia? " + fila.isEmpty()); // Saída: false

    }

}