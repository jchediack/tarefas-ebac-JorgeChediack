package generics.tarefa17;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<Carros> carros = new ArrayList<>();
        carros.add(new Civic());
        carros.add(new Honda());
        carros.add(new Jeep());

        imprimirCarros(carros);

    }

    public static void imprimirCarros(List<? extends Carros> lista) {
        for (Carros carros : lista ) {
            System.out.println(lista);
        }
    }

}
