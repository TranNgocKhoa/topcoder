import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class RoomNumber {

    public int numberOfSets(int roomNumber) {
        int[] counts = new int[10];
        while (roomNumber > 0) {
            counts[roomNumber % 10]++;
            roomNumber /= 10;
        }

        int max = (counts[6] + counts[9]) / 2 % 2 == 0 ? (counts[6] + counts[9]) / 2 : (counts[6] + counts[9]) / 2 + 1;
        for (int i = 0; i < 10; ++i) {
            if (i != 6 && i != 9) {
                if (counts[i] > max) {
                    max = counts[i];
                }
            }
        }
        return max;
    }
}
