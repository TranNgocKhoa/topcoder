import java.util.Arrays;
import java.util.Scanner;

public class ChangeDP {
    static int[] coins = new int[]{4, 3, 1};

    private static int getChangeRecursion(int m) {
        return getChange(m, m);
    }

    private static int getChangeDp(int m) {
        int[] minCoins = new int[m + 1];
        Arrays.fill(minCoins, m);
        minCoins[0] = 0;

        for (int i = 0; i <= m; i++) {
            for (int coin : coins) {
                if (i >= coin && i > 0) {
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coin]);
                }
            }
        }

        return minCoins[m];
    }

    private static int getChange(int amount, int min) {
        if (amount <= 0) {
            return 0;
        }

        for (int coin : coins) {
            if (amount >= coin) {
                int result = 1 + getChange(amount - coin, min);
                if (result < min) {
                    min = result;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChangeRecursion(m));
        System.out.println(getChangeDp(m));

    }
}