import java.util.Scanner;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquares(long n) {
        if (n <= 1) {
            return n;
        }

        long remainderModulo60 = n % 60;
        long lastDigitFibonacciN = remainderModulo60;
        if (remainderModulo60 > 1) {
            lastDigitFibonacciN = getFibonacci(remainderModulo60) % 10;
        }
        long remainderModulo60Minus1 = n % 60 - 1;
        long lastDigitFibonacciNMinus1 = remainderModulo60Minus1;
        if (remainderModulo60Minus1 > 1) {
            lastDigitFibonacciNMinus1 = getFibonacci(remainderModulo60Minus1) % 10;
        }

        return (lastDigitFibonacciN * (lastDigitFibonacciNMinus1 + lastDigitFibonacciN)) % 10;
    }

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


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquares(n);
        System.out.println(s);
    }
}