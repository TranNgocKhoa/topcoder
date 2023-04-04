import java.util.Scanner;

public class Change {
    static int[] denominations = new int[]{10, 5, 1};

    private static int getChange(int m) {
        int count = 0;
        for (int denomination : denominations) {
            while (m >= denomination) {
                count++;
                m -= denomination;
            }
        }

        return count;
    }

    private static int getChangeNoCycle(int m) {
        return m / 10 + (m % 10) / 5 + ((m % 10) / 5);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
        System.out.println(getChangeNoCycle(m));

    }
}