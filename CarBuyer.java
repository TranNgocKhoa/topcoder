import java.util.Arrays;

public class CarBuyer {

    public double lowestCost(String[] cars, int fuelPrice, int annualDistance, int years) {
        String[] firstCar = cars[0].split(" ");
        int[] car1 = Arrays.stream(firstCar).mapToInt(Integer::parseInt).toArray();
        double lowest = this.calculate(car1, annualDistance, fuelPrice, years);

        for(int i = 1; i < cars.length; ++i) {
            String[] car = cars[i].split(" ");
            int[] aCar = Arrays.stream(car).mapToInt(Integer::parseInt).toArray();
            double p = this.calculate(aCar, annualDistance, fuelPrice, years);
            lowest = Math.min(lowest, p);
        }

        return lowest;
    }

    private double calculate(int[] elements, int annualDistance, int fuelPrice, int years) {
        return (double)(elements[0] + elements[1] * years) + (double)(years * fuelPrice * annualDistance) / (double)elements[2];
    }
}
