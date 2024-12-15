package longest_substring_without_repeating;

import java.util.HashMap;

public class Solution {

    public static int findLongestSubstring(String str) {
        if (str.length() == 0) {
            return 0;
        }

        int n = str.length();
        int windowStart = 0, longest = 0, windowLength = 0, i = 0;

        HashMap<Character, Integer> lastSeenAt = new HashMap<>();

        for (i = 0; i < n; i++) {
            if (!lastSeenAt.containsKey(str.charAt(i))) {
                lastSeenAt.put(str.charAt(i), i);
            } else {
                if (lastSeenAt.get(str.charAt(i)) >= windowStart) {
                    windowLength = i - windowStart;
                    if (longest < windowLength) {
                        longest = windowLength;
                    }
                    windowStart = lastSeenAt.get(str.charAt(i)) + 1;
                }
                lastSeenAt.replace(str.charAt(i), i);
            }
        }

        if (longest < i - windowStart) {
            longest = i - windowStart;
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(findLongestSubstring("abcdbea"));
    }
}
