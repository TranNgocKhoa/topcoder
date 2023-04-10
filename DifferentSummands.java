import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int k = 1;
        while (k * (k + 1) / 2 <= n) {
            k++;
        }

        k--;

        int delta = n - k * (k + 1) / 2;
        for (int i = 1; i < k; i++) {
            summands.add(i);
        }
        summands.add(k + delta);

        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}