import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class DistanceBetweenStrings {

    public int getDistance(String a, String b, String letterSet) {
        int distA = 0;
        int distB = 0;
        for (int i = 0; i < letterSet.length(); ++i) {
            distA += getDistance(a, b, letterSet.charAt(i));
            distB += getDistance(b, b, letterSet.charAt(i));
        }
        return (distA + distB);
    }

    private int getDistance(String a, String b, char c) {
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (c == a.charAt(i)) countA++;
        }
        for (int i = 0; i < b.length(); ++i) {
            if (c == b.charAt(i)) countB++;
        }
        return (countA - countB) * (countA - countB);
    }
}
