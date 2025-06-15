package longest_palindromic_substring;

public class BruteForce {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String longestPalindrome = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub)) {
                    if (sub.length() > longestPalindrome.length()) {
                        longestPalindrome = sub;
                    }
                }
            }
        }

        return longestPalindrome;
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        BruteForce bf = new BruteForce();
        System.out.println(bf.longestPalindrome("a"));
    }
}
