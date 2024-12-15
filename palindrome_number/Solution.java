package palindrome_number;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int temp = x;
        int reverse = 0;
        while (temp != 0) {
            reverse = reverse * 10 + temp % 10;
            temp /= 10;
        }

        return reverse == x;
    }

    public boolean isPalindrome(String x) {
        if (x.length() == 0) {
            return true;
        }
        int low = 0;
        int high = x.length() - 1;

        while (low < high) {
            if (x.charAt(low) != x.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("3113"));
    }
}
