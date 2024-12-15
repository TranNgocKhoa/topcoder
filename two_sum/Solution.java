package two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (positionMap.containsKey(target - nums[i])) {
                return new int[]{positionMap.get(target - nums[i]), i};
            }
            positionMap.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
