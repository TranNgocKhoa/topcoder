import java.util.*;

public class MaximumDistanceInArray {

    public int maxDistance(List<List<Integer>> arrays) {
        int maxDistance = 0;
        boolean init = false;

        Set<String> compared = new HashSet<>();

        for (int i = 0; i < arrays.size(); i++) {
            for (int j = 0; j < arrays.size(); j++) {
                if (i == j) {
                    continue;
                }

                if (compared.contains(i + "-" + j)) {
                    continue;
                }

                compared.add(i + "-" + j);

                List<Integer> array1 = arrays.get(i);
                List<Integer> array2 = arrays.get(j);
                int max1 = Math.abs(array1.get(array1.size() - 1) - array2.get(0));
                int max2 = Math.abs(array2.get(array2.size() - 1) - array1.get(0));

                if (!init) {
                    maxDistance = Math.max(max1, max2);
                    init = true;
                } else {
                    maxDistance = Math.max(maxDistance, Math.max(max1, max2));
                }
            }
        }

        return maxDistance;
    }

    public static void main(String[] args) {


        ArrayList<List<Integer>> objects = new ArrayList<>();
        objects.add(Arrays.asList(-1, 5));
        objects.add(Arrays.asList(1, 4, 6));
        objects.add(Arrays.asList(4, 5, 6));

        MaximumDistanceInArray maximumDistanceInArray = new MaximumDistanceInArray();
        System.out.println(maximumDistanceInArray.maxDistance(objects));

    }
}
