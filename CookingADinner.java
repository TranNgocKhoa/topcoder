import java.util.Scanner;

public class CookingADinner {
    /**
     * Cooking a Dinner
     * Given an array that describes time it takes to cook each of n dishes and an array that describes how long the dishes stay fresh,
     * is there an order of cooking these dishes that ensures that at some point all of them are fresh?
     *
     * @Input: You are cooking n dishes for a dinner. For the i-th dish, it takes c_i minutes to cook it, after which it stays fresh for f_i minutes.
     * @Output: Is there an order of cooking these n dishes that ensures that at some point all of them are fresh?
     * Assume that you cook them one by one and cannot parallelize your work.
     **/


    static String cookADinner(int n, int[] cookingTimes, int[] freshTimes) {
        if (isContainsFreshTimeCover(n, cookingTimes, freshTimes)) {
            return "Yes";
        }

        return "No";
    }

    static boolean isContainsFreshTimeCover(int n, int[] cookingTimes, int[] freshTimes) {
        if (n <= 1) {
            return true;
        }
        int maxSpanTime = freshTimes[0] + cookingTimes[0];

        int maxSpanTimeIndex = 0;

        for (int i = 1; i < n; i++) {
            int spanTime = freshTimes[i] + cookingTimes[i];
            if (maxSpanTime < spanTime) {
                maxSpanTime = spanTime;
                maxSpanTimeIndex = i;
            }
        }

        int sumCookingTime = 0;
        for (int i = 0; i < n; i++) {
            if (i != maxSpanTimeIndex) {
                sumCookingTime += cookingTimes[i];
            }
        }

        if (freshTimes[maxSpanTimeIndex] >= sumCookingTime) {
            return isContainsFreshTimeCover(n - 1, removeAt(cookingTimes, maxSpanTimeIndex), removeAt(freshTimes, maxSpanTimeIndex));
        } else {
            return false;
        }
    }

    static int[] removeAt(int[] a, int index) {
        int count = 0;
        int[] result = new int[a.length - 1];
        for (int i = 0; i < a.length; i++) {
            if (i != index) {
                result[count++] = a[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        String s = cookADinner(3, new int[]{3, 2, 1}, new int[]{1, 6, 1});
//        System.out.println(s);

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] cookingTimes = new int[n];
        int[] freshTimes = new int[n];
        for (int i = 0; i < n; i++) {
            int cooking, fresh;
            cooking = scanner.nextInt();
            fresh = scanner.nextInt();
            cookingTimes[i] = cooking;
            freshTimes[i] = fresh;
        }

        System.out.println(cookADinner(n, cookingTimes, freshTimes));
    }
}
