package first_occurence_in_string;

import java.util.Map;

class Solution {
    public int strStr(String haystack, String needle) {
        char[] haystackCharArray = haystack.toCharArray();
        char[] needleCharArray = needle.toCharArray();

        int index = -1;
        for (int i = 0; i < haystackCharArray.length - needleCharArray.length + 1; i++) {
            if (haystackCharArray[i] == needleCharArray[0]) {
                index = i;
                for (int j = 0; j < needleCharArray.length; j++) {
                    if (haystackCharArray[i + j] != needleCharArray[j]) {
                        index = -1;
                        break;
                    }
                }
                if (index >= 0) {
                    return index;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("a", "a"));
        System.out.println(new Solution().strStr("sadbutsad", "sad"));
        System.out.println(new Solution().strStr("leetcode", "leeto"));
        System.out.println(new Solution().strStr("mississippi", "issip"));
    }
}