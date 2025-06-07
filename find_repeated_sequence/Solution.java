package find_repeated_sequence;

import java.util.*;

public class Solution {
    public static Set<String> findRepeatedSequences(String dna, int k) {

        int stringLength = dna.length();

        if (stringLength < k) {
            return new HashSet<String>();
        }

        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('A', 1);
        mapping.put('C', 2);
        mapping.put('G', 3);
        mapping.put('T', 4);

        int baseValue = 4;

        List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[stringLength]));
        Arrays.fill(numbers.toArray(), 0);
        for (int i = 0; i < stringLength; i++) {
            numbers.set(i, mapping.get(dna.charAt(i)));
        }

        int hashValue = 0;

        Set<Integer> hashSet = new HashSet<>();
        Set<String> output = new HashSet<>();

        for (int i = 0; i < stringLength - k + 1; i++) {
            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    hashValue += numbers.get(j) * (int) Math.pow(baseValue, k - j - 1);
                }
            } else {
                int previousHashValue = hashValue;
                hashValue = ((previousHashValue - numbers.get(i - 1) * (int) Math.pow(baseValue, k - 1)) * baseValue) + numbers.get(i + k - 1);
            }

            if (hashSet.contains(hashValue)) {
                output.add(dna.substring(i, i + k));
            }

            hashSet.add(hashValue);
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedSequences("CAAACCCCGTAAACCCCA", 7));
    }
}
