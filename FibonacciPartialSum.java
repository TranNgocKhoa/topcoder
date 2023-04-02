public class FibonacciPartialSum {
    //Finding the Last Digit of the Partial Sum of Fibonacci Numbers
    //Given integers m and n, where m ≤ n, find the last digit of the partial sum of Fibonacci numbers from Fm to Fn, inclusive.
    //The partial sum is computed as:
    //Fm + Fm+1 + ... + Fn-1 + Fn

    //Input: m <= n
    //Output the last digit of this sum.

    private static long getFibonacciPartialSum(long from, long to) {
        if (to <= 1) {
            return to;
        }

        long fibonacciSumFrom = 0;
        if (from > 0) {
            fibonacciSumFrom = getFibonacciSum(((from - 1) % 60));
        }
        long fibonacciSumTo = getFibonacciSum((to % 60));
        if (fibonacciSumTo < fibonacciSumFrom) {
            fibonacciSumTo += 10;

        }

        return (fibonacciSumTo - fibonacciSumFrom) % 10;
    }

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

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        long from = scanner.nextLong();
//        long to = scanner.nextLong();
//        System.out.println(getFibonacciPartialSumNaive(from, to));

        System.out.println(getFibonacciPartialSum(1, 2)); // 2
        System.out.println(getFibonacciPartialSum(0, 7)); // 3
        System.out.println(getFibonacciPartialSum(10, 10)); // 5
        System.out.println(getFibonacciPartialSum(3, 7)); // 1
    }
}