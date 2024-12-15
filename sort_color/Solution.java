package sort_color;

/**
 * Given an array, colors, which contains a combination of the following three elements:
 * 0 (representing red)
 * <p>
 * 1 (representing white)
 * <p>
 * 2 (representing blue)
 * <p>
 * Sort the array in place so that the elements of the same color are adjacent, with the colors in the order of red, white, and blue.
 * To improve your problem-solving skills, do not utilize the built-in sort function.
 */

public class Solution {

    public int[] sortColors(int[] colors) {
        int start = 0;
        int current = 0;
        int end = colors.length - 1;

        while (current <= end) {
            if (colors[current] == 0) {
                exchange(colors, start, current);

                start++;
                current++;
            } else if (colors[current] == 1) {
                current++;
            } else if (colors[current] == 2) {
                exchange(colors, end, current);
                end--;
            }
        }

        return colors;
    }

    private void exchange(int[] colors, int low, int high) {
        int temp = colors[low];
        colors[low] = colors[high];
        colors[high] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        for (int i : solution.sortColors(new int[]{2, 1, 0, 1, 0})) {
            System.out.print(i);
            System.out.print(", ");
        }

        System.out.println();
        for (int i : solution.sortColors(new int[]{1, 0, 1})) {
            System.out.print(i);
            System.out.print(", ");
        }


    }
}
