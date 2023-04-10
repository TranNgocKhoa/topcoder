import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        int[] table = new int[n + 1];
        table[1] = 0;
        for (int i = 2; i <= n; i++) {
            int min = 1 + table[i - 1];
            if (i % 2 == 0) {
                min = Math.min(1 + table[i / 2], min);
            }
            if (i % 3 == 0) {
                min = Math.min(1 + table[i / 3], min);
            }

            table[i] = min;
        }

        List<Integer> sequence = new ArrayList<Integer>();
        while (n > 1) {
            sequence.add(n);
            if (table[n] == table[n - 1] + 1) {
                n = n - 1;
            } else if (n % 2 == 0 && table[n] == table[n / 2] + 1) {
                n = n / 2;
            } else if (n % 3 == 0 && table[n] == table[n / 3] + 1) {
                n = n / 3;
            }
        }
        sequence.add(1);

        Collections.reverse(sequence);

        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (int i = 0; i < sequence.size(); i++) {
            if (i == sequence.size() - 1) {
                System.out.print(sequence.get(i));
            } else {
                System.out.print(sequence.get(i) + " ");
            }
        }
    }
}