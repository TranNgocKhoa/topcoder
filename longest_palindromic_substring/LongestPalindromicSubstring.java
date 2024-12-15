package longest_palindromic_substring;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }

        boolean[][] dp = new boolean[n][n];

        // Các trường hợp cơ bản: ký tự đơn lẻ và các ký tự liền kề là đối xứng
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }

        int maxLen = 1;
        int start = 0;
        for (int subStringLength = 2; subStringLength <= n; subStringLength++) {
            for (int i = 0; i < n - subStringLength + 1; i++) {
                int j = i + subStringLength - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (subStringLength > maxLen) {
                        maxLen = subStringLength;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s = "babad";
        String result = longestPalindrome(s);
        System.out.println(result); // Output: "bab"
    }
}