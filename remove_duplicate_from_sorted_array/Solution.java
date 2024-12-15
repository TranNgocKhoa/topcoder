package remove_duplicate_from_sorted_array;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 1) {
            return 1;
        }

        if (nums.length == 0) {
            return 0;
        }

        int index = 0;

        for (int i = index + 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }

    public static void main(String[] args) {
        int[] ints1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] ints2 = {1, 1, 2};
        int[] ints = {1, 1};

        System.out.println(new Solution().removeDuplicates(ints1));

        System.out.println(Arrays.toString(ints1));
    }
}
