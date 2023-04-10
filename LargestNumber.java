import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";

        while (a.length > 0) {
            String maxNumber = a[0];
            int maxIndex = 0;
            for (int i = 1; i < a.length; i++) {
                if (isBetter(a[i], maxNumber)) {
                    maxNumber = a[i];
                    maxIndex = i;
                }
            }

            result = result + maxNumber;

            a = removeAt(a, maxIndex);
        }
        return result;
    }

    private static String[] removeAt(String[] a, int index) {
        String[] newStrings = new String[a.length - 1];
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (i != index) {
                newStrings[count++] = a[i];
            }
        }

        return newStrings;
    }

    private static boolean isBetter(String s, String maxNumber) {
        if (Long.parseLong(s + maxNumber) > Long.parseLong(maxNumber + s)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}