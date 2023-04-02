import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        int n = numbers.length;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return numbers[0];
        }

        int[] pairMax = maxPair(numbers);

        return (long) pairMax[0] * pairMax[1];
    }

    static int[] maxPair(int[] numbers) {
        int max = -1;
        int secondMax = -1;

        for (int number : numbers) {
            if (number >= max) {
                secondMax = max;
                max = number;
            } else if (number >= secondMax) {
                secondMax = number;
            }
        }

        return new int[]{max, secondMax};
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}