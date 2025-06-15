package randomized_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class RandomizedSet {
    private List<Integer> keys;
    private HashMap<Integer, Integer> valueToIndex;

    public RandomizedSet() {
        keys = new ArrayList<>();
        valueToIndex = new HashMap<>();
    }

    public boolean insert(int val) {
        if (!valueToIndex.containsKey(val)) {
            keys.add(val);
            valueToIndex.put(val, keys.size() - 1);
            return true;
        }

        return false;
    }

    public boolean remove(int val) {
        if (valueToIndex.containsKey(val)) {
            int indexToRemove = valueToIndex.get(val);

            int lastElement = keys.get(keys.size() - 1);
            if (indexToRemove != keys.size() - 1) {
                keys.set(indexToRemove, lastElement);
                valueToIndex.put(lastElement, indexToRemove);
            }

            keys.remove(keys.size() - 1);
            valueToIndex.remove(val);

            return true;
        }

        return false;
    }

    public int getRandom() {
        return keys.get((int) (Math.random() * keys.size()));
    }
}