public class RangeSumQuery {

    private static long[] rangeSumNaive(int[] inputArray, int[][] ranges) {
        long[] sums = new long[ranges.length];

        for (int i = 0; i < ranges.length; i++) {
            long sum = 0;
            for (int j = ranges[i][0]; j < ranges[i][1]; j++) {
                sum += inputArray[j];
            }

            sums[i] = sum;
        }

        return sums;
    }

    private static long[] preSum(int[] inputArray) {
        long[] preSums = new long[inputArray.length];

        long sum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            sum += inputArray[i];
            preSums[i] = sum;
        }

        return preSums;
    }

    private static long[] rangeSum(int[] inputArray, int[][] ranges) {
        long[] preSum = preSum(inputArray);
        long[] sums = new long[ranges.length];

        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i][0] <= 0) {
                sums[i] = preSum[ranges[i][1] - 1];
            } else {
                sums[i] = preSum[ranges[i][1] - 1] - preSum[ranges[i][0] - 1];
            }
        }

        return sums;
    }


    public static void main(String[] args) {
        long[] longs = rangeSumNaive(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[][]{{1, 2}, {3, 4}, {3, 8}});
        long[] longs1 = rangeSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[][]{{1, 2}, {3, 4}, {3, 8}});

        for (int i = 0; i < longs.length; i++) {
            System.out.println(longs[i]);
            System.out.println(longs1[i]);
        }
    }
}
