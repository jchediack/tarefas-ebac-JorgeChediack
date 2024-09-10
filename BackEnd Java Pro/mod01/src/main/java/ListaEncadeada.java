class Node {

    int data;

    Node next;

    public Node(int data) {

        this.data = data;

        this.next = null;

    }

}

public class ListaEncadeada {

    private Node head;

    private int size;

    public ListaEncadeada() {

        this.head = null;

        this.size = 0;

    }

    public void push(Node node) {

        if (head == null) {

            head = node;

        } else {

            Node current = head;

            while (current.next != null) {

                current = current.next;

            }

            current.next = node;

        }

        size++;

    }

    public Node pop() {

        if (head == null) {

            throw new IllegalStateException("A lista está vazia");

        }

        if (head.next == null) {

            Node temp = head;

            head = null;

            size--;

            return temp;

        }

        Node current = head;

        while (current.next.next != null) {

            current = current.next;

        }

        Node temp = current.next;

        current.next = null;

        size--;

        return temp;

    }

    public void insert(int index, Node node) {

        if (index < 0 || index > size) {

            throw new IndexOutOfBoundsException("Índice inválido");

        }

        if (index == 0) {

            node.next = head;

            head = node;

        } else {

            Node current = head;

            for (int i = 0; i < index - 1; i++) {

                current = current.next;

            }

            node.next = current.next;

            current.next = node;

        }

        size++;

    }

    public void remove(int index) {

        if (index < 0 || index >= size) {

            throw new IndexOutOfBoundsException("Índice inválido");

        }

        if (index == 0) {

            head = head.next;

        } else {

            Node current = head;

            for (int i = 0; i < index - 1; i++) {

                current = current.next;

            }

            current.next = current.next.next;

        }

        size--;

    }

    public Node elementAt(int index) {

        if (index < 0 || index >= size) {

            throw new IndexOutOfBoundsException("Índice inválido");

        }

        Node current = head;

        for (int i = 0; i < index; i++) {

            current = current.next;

        }

        return current;

    }

    public int size() {

        return size;

    }

    public void printList() {

        Node current = head;

        while (current != null) {

            System.out.print(current.data + " -> ");

            current = current.next;

        }

        System.out.println("null");

    }

    public static void main(String[] args) {

        ListaEncadeada lista = new ListaEncadeada();

        // Teste

        lista.push(new Node(10));

        lista.push(new Node(20));

        lista.push(new Node(30));

        lista.printList(); // Saída: 10 -> 20 -> 30 -> null

        lista.insert(1, new Node(15));

        lista.printList(); // Saída: 10 -> 15 -> 20 -> 30 -> null

        lista.remove(2);

        lista.printList(); // Saída: 10 -> 15 -> 30 -> null

        System.out.println("Elemento no índice 1: " + lista.elementAt(1).data); // Saída: 15

        System.out.println("Tamanho da lista: " + lista.size()); // Saída: 3

        lista.pop();

        lista.printList(); // Saída: 10 -> 15 -> null

    }

}

