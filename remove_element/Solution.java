package remove_element;

class Solution {
    public int removeElement(int[] nums, int val) {
        int[] ints = new int[nums.length];

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                ints[index++] = nums[i];
            }
        }

        for (int i = 0; i < ints.length; i++) {
            nums[i] = ints[i];
        }

        return index;
    }

    public static void main(String[] args) {

    }
}