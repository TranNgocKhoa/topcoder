import java.util.Scanner;

public class FibonacciSumLastDigitEnhance {
    private static long getFibonacciSum(long n) {
        if (n <= 1) {
            return n;
        }

        long remainderInPisanoPeriod = n % 60;
        long fibonacciNPlus2 = getFibonacci(remainderInPisanoPeriod + 2);

        return (fibonacciNPlus2 - 1) % 10;
    }

    // n > 1
    private static long getFibonacci(long n) {
        long previousLast = 0;
        long last = 1;

        for (int i = 2; i <= n; i++) {
            long sum = previousLast + last;
            previousLast = last;
            last = sum;
        }

        return last;
    }

    private static long getFibonacciSumNaive(long n) {
        if (n <= 1) {
            return n;
        }

        long previous = 0;
        long current = 1;
        long sum = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tempPrevious = previous;
            previous = current % 10;
            current = (tempPrevious + current) % 10;
            sum = (sum + current) % 10;
        }

        return sum % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 3; i < 10_000; i++) {
            long s = getFibonacciSum(i);
            long s1 = getFibonacciSumNaive(i);

            if (s != s1) {
                System.out.println("Wrong " + i + " => " + s1 + " actual " + s);
            }
        }
//        long n = scanner.nextLong();
//        long s = getFibonacciSum(n);
//        long s1 = getFibonacciSumNaive(n);
//        System.out.println(s);
//        System.out.println(s);
    }
}