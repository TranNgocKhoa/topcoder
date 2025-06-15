package single_element_in_sorted_array;

import java.util.Arrays;

class SingleElement {
    public static int singleNonDuplicate(int[] nums) {

        // initialize the left and right pointer
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {

            // if mid is odd, decrement it to make it even
            int mid = l + (r - l) / 2;
            // If, at any point, mid is an odd numbered index, we change it to an even numbered index.
            // This makes it easier to check whether mid is part of a pair of integers in nums.
            // Because if number stay in pair, even position is the start of pair
            if (mid % 2 == 1) {
                mid--;
            }

            // if the elements at mid and mid + 1 are the same, then the single element must appear after the midpoint
            // Right part has problem
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            }
            // otherwise, we must search for the single element before the midpoint
            // Left part has problem
            else {
                r = mid;
            }
        }
        return nums[l];
    }

    // Driver code
    public static void main(String[] args) {
        int[][] inputs = {
                {1, 2, 2, 3, 3, 4, 4},
                {1, 1, 2, 2, 3, 4, 4, 5, 5},
                {1, 1, 2, 3, 3},
                {1, 1, 2},
                {0, 2, 2, 3, 3, 4, 4, 5, 5}
        };
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput array: " + Arrays.toString(inputs[i]));
            System.out.println("\n\tSingle element found: " + singleNonDuplicate(inputs[i]));
        }
    }
}