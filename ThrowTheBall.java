import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class ThrowTheBall {

    public int timesThrown(int N, int M, int L) {
        int ball = 0;
        int count = 0;
        int[] counts = new int[N];
        while (true) {
            counts[ball]++;
            if (counts[ball] == M) return count;

            if (counts[ball] % 2 == 0) {
                ball = (ball + L) % N;
            } else  {
                ball = (ball + (N - L)) % N;
            }
            count++;
        }
    }
}

