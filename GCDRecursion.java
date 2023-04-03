import java.util.Scanner;

public class GCDRecursion {
    private static int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return Math.max(a, b);
        }
        if (a > b) {
            return gcd(b, a % b);
        }

        return gcd(a, b % a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcd(a, b));
    }
}