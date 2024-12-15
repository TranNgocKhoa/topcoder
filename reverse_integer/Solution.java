package reverse_integer;

class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        boolean negative = x < 0;
        if (negative) {
            x = -x;
        }

        int result = 0;
        while (x != 0) {
            int n = x % 10;
            x /= 10;

            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result = result * 10 + n;
        }

        return negative ? - 1 * result : result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(11121));
        System.out.println(new Solution().reverse(1534236469));
        System.out.println(new Solution().reverse(-2147483648));
    }
}