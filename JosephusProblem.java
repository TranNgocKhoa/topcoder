import java.util.Arrays;

public class JosephusProblem {

    private static int josephusNaive(int n, int k) {
        int[] prisons = new int[n];
        Arrays.fill(prisons, 1);

        int prisonLeft = n;
        int index = 0;
        while (prisonLeft > 1) {
            int jump = 0;
            while (jump < k - 1) {
                if (prisons[index] == 1) {
                    jump++;
                }
                index = (index + 1) % n;
            }
            while (prisons[index] != 1) {
                index = (index + 1) % n;
            }

            prisons[index] = 0;
            index = (index + 1) % n;
            prisonLeft--;
        }

        for (int i = 0; i < n; i++) {
            if (prisons[i] == 1) {
                return i;
            }
        }

        return -1;
    }


    private static int josephus(int n, int k) {
        if (n == 1) {
            return 0;
        }

        return (josephus(n - 1, k) + k) % n;
    }


    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();

        System.out.println(josephusNaive(9, 3));
        System.out.println(josephus(9, 3));

        System.out.println(josephusNaive(9, 4));
        System.out.println(josephus(9, 4));

        System.out.println(josephusNaive(9, 5));
        System.out.println(josephus(9, 5));

        System.out.println(josephusNaive(41, 3));
        System.out.println(josephus(41, 3));
    }
}
