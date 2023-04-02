import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciSumLastDigit {
    private static long getFibonacciSum(long n) {
        if (n <= 1) {
            return n;
        }
        Long[] periodArrayTen = calculatePeriodArrayTen();

        long sumPeriod = 0;
        if (n > periodArrayTen.length) {
            for (Long value : periodArrayTen) {
                sumPeriod += value;
            }
        }

        long sum = (n / periodArrayTen.length) * sumPeriod % 10;

        for (int i = 0; i <= n % periodArrayTen.length; i++) {
            sum = (sum + periodArrayTen[i]);
        }

        return sum % 10;
    }

    private static Long[] calculatePeriodArrayTen() {
        List<Long> periodList = new ArrayList<>();
        long previous = 0;
        long current = 1;
        periodList.add(previous);
        periodList.add(current);

        do {
            long tmp_previous = previous;
            previous = current % 10;
            current = (tmp_previous + current) % 10;
            if (previous != 0 || current != 1) {
                periodList.add(current);
            } else {
                periodList.remove(periodList.size() - 1);
            }
        } while (previous != 0 || current != 1);

        return periodList.toArray(new Long[]{});
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