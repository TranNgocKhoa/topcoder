import java.util.Scanner;

public class Fibonacci {
    private static long calc_fib(int n) {
        if (n <= 1) {
            return n;
        }

        long previousLast = 0;
        long last = 1;

        for (int i = 2; i <= n; i++) {
            long sum = previousLast + last;
            previousLast = last;
            last = sum;
        }

        return last;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }
}