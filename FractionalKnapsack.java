import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        if (capacity <= 0 || values.length == 0 || weights.length == 0) {
            return 0;
        }
        int maxUnitIndex = 0;

        // (double) values[i] / weights[i] > (double) values[m] / weights[m]
        // =>  values[i] * weights[m] > values[m] * weights[i]
        for (int i = 0; i < values.length; i++) {
            if (values[i] * weights[maxUnitIndex] >= values[maxUnitIndex] * weights[i]) {
                maxUnitIndex = i;
            }
        }

        int amount = Math.min(capacity, weights[maxUnitIndex]);
        double value = ((double) values[maxUnitIndex]) / weights[maxUnitIndex] * amount;

        int[] newValues = new int[values.length - 1];
        int[] newWeights = new int[weights.length - 1];

        int index = 0;
        for (int i = 0; i < values.length; i++) {
            if (i != maxUnitIndex) {
                newValues[index] = values[i];
                newWeights[index] = weights[i];
                index++;
            }
        }

        return value + getOptimalValue(capacity - amount, newValues, newWeights);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }

        System.out.println(String.format("%.4f", getOptimalValue(capacity, values, weights)));
    }
    //3 50
    //60 20
    //100 50
    //120 30
    // 180.0000

    //1 10
    //500 30
    // 166.6667
}