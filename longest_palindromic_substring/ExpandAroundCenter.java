package longest_palindromic_substring;

public class ExpandAroundCenter {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            // Kiem tra doi voi do dai le
            int len1 = expandAroundCenter(s, i, i).length();
            // Kiem tra doi voi do dai chan
            int len2 = expandAroundCenter(s, i, i + 1).length();

            int len = Math.max(len1, len2);

            // e d d e

            if (len1 > len2) {
                if (len > right - left + 1) {
                    left = i - (len - 1) / 2;
                    right = i + (len - 1) / 2;
                }
            } else {
                if (len > right - left + 1) {
                    left = i - (len - 1) / 2;
                    right = i + (len) / 2;
                }
            }
        }

        return s.substring(left, right + 1);
    }

    private String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        ExpandAroundCenter bf = new ExpandAroundCenter();
        System.out.println(bf.longestPalindrome("aa"));
        System.out.println(bf.longestPalindrome("aca"));
        System.out.println(bf.longestPalindrome("acddadd"));
    }
}
