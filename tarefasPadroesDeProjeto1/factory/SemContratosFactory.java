package factory;

public class SemContratosFactory extends Factory {


    @Override
    Car retrieveCar(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new BrasiliaCar(50, "cheio", "rosa");
        } else {
            return new CompassCar(250, "vazio", "cinza metálico");
        }
    }
}
