import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class CyclicWords {

    public int differentCW(String[] words) {
        String[] originals = new String[words.length];
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (isNewWord(originals, words[i])) {
                originals[count] = words[i];
                count++;

            }
        }
        return count;
    }

    private boolean isNewWord(String[] ws, String word) {
        int i = 0;
        while (ws[i] != null) {
            if (word.length() == ws[i].length() && isCirclic(ws[i], word)) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean isCirclic(String a, String b) {
        if (a.equals(b)) return true;
        for (int i = 0; i < a.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(b.charAt(b.length() - 1));
            sb.append(b, 0, b.length() - 1);
            b = sb.toString();
            if (a.equals(b)) return true;
        }
        return false;
    }
}
