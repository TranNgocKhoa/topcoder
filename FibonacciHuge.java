import java.util.Scanner;

public class FibonacciHuge {
    private static long getFibonacciHuge(long n, long m) {
        long previous = 0;
        long current = 1;

        long period = calculatePeriod(m);

//        System.out.println("Period => " + period);
//        System.out.println("Max = " + ((n % period) - 1));

        long newNValue = (n % period);
//        System.out.println("new value = " + newNValue);

        if (newNValue <= 1) {
            return newNValue;
        }

        for (long i = 0; i < (n % period) - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;
        }

        return current % m;
    }

    private static long calculatePeriod(long m) {
        if (m <= 1) {
            return m;
        }
        long period = 2;

        long previous = 0;
        long current = 1;

        do {
            long tmp_previous = previous;
            previous = current % m;
            current = (tmp_previous + current) % m;
            period++;
        } while (previous != 0 || current != 1);

        return period - 2;
    }

    public static void main(String[] args) {

        // 2816213588 239 => 151
        // 9999999999999 2  => 0
        // 1000 100  => 75
        // 10 2  => 1

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}