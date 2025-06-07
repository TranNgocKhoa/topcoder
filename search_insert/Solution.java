package search_insert;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    private int searchValue(int[] nums, int start, int end, int target) {
        System.out.println("Start " + start + ". End " + end);
        if (end - start < 2) {
           if (nums[start] == target) {
               return start;
           } else if (nums[end] == target) {
               return end;
           } else if (nums[start] > target) {
               return start;
           } else if (nums[end] < target) {
               return end + 1;
           } else {
               return start + 1;
           }


        }

        int middle = start + (end - start) / 2;

        System.out.println("Middle " + middle);

        if (nums[middle] == target) {
            return middle;
        }

        if (nums[middle] > target) {
            if (nums[middle - 1] >= target) {
                return searchValue(nums, start, middle - 1, target);
            }

            return middle;
        }

        if (nums[middle] < target) {
            if (nums[middle + 1] <= target) {
                return searchValue(nums, middle + 1, end, target);
            }
        }

        return middle + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[]{3, 5, 7, 9, 10}, 8));
        System.out.println(solution.searchInsert(new int[]{1, 3}, 0));
        System.out.println(solution.searchInsert(new int[]{1, 3}, 2));
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(solution.searchInsert(new int[]{1,3,5}, 1));
    }
}