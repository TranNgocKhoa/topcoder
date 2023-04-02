import java.util.Scanner;

public class GCD {
    private static int gcd_naive(int a, int b) {
        int currentGcd = 1;
        while (a > 0 && b > 0) {
            if (a > b) {
                if (a % b == 0) {
                    return b;
                }
                a = a % b;
            } else {
                if (b % a == 0) {
                    return a;
                }
                b = b % a;
            }
        }

        return currentGcd;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcd_naive(a, b));
    }
}