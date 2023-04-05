import java.util.Scanner;

//Car Fueling
//
//Given integers d and m, as well as a sequence of integers stop1, stop2, ..., stopn where stop1 < stop2 < ... < stopn,
//compute the minimum number of gas tank refills needed to travel from one city to another.
//Assume a car can travel at most m miles on a full tank, the distance between the cities is d miles,
//and there are gas stations at distances stop1, stop2, ..., stopn along the way.
//We also assume that the car starts with a full tank.
//
//Output the minimum number of gas tank refills needed to complete the journey.
public class CarFueling {
    static int computeMinRefills(int dist, int tankMaxDistance, int[] stops) {
        return refills(0, stops, dist, tankMaxDistance);
    }

    static int refills(int location, int[] stops, int distance, int tankMaxDistance) {
        if (location + tankMaxDistance >= distance) {
            return 0;
        }

        if (stops.length == 0 || stops[0] - location > tankMaxDistance) {
            return -1;
        }

        int lastStop = location;
        while (stops.length > 0 && stops[0] - location <= tankMaxDistance) {
            lastStop = stops[0];
            stops = removeIndex(stops, 0);
        }

        int remainRefill = refills(lastStop, stops, distance, tankMaxDistance);
        if (remainRefill == -1) {
            return -1;
        }
        return 1 + remainRefill;
    }

    private static int[] removeIndex(int[] inputArray, int index) {
        int[] result = new int[inputArray.length - 1];
        int counter = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i != index) {
                result[counter] = inputArray[i];
                counter++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}