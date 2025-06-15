package string_to_integer;

public class Solution {
    public int myAtoi(String str) {
        str = str.trim();

        if (str.isEmpty()) {
            return 0;
        }

        int start = 0;
        int sign = 1;
        if (str.charAt(0) == '-') {
            sign = -1;
            start = 1;
        } else if (str.charAt(0) == '+') {
            start = 1;
        }

        int result = 0;
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9) {
                if (sign == 1) {
                    if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                        return Integer.MAX_VALUE;
                    }
                    result = result * 10 + (str.charAt(i) - '0');

                } else {
                    if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && str.charAt(i) - '0' > 8)) {
                        return Integer.MIN_VALUE;
                    }

                    result = result * 10 - (str.charAt(i) - '0');
                }

            } else {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.myAtoi("+1"));
        System.out.println(solution.myAtoi("-1000"));
        System.out.println(solution.myAtoi("-100c0"));

    }
}
