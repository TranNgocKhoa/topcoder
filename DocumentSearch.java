import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class DocumentSearch {

    public int nonIntersecting(String[] doc, String search) {
        StringBuilder sb = new StringBuilder();
        for (String s : doc) {
            sb.append(s);
        }
        int count = 0;
        int docLen = sb.toString().length();
        int searchLen = search.length();
        for (int i = 0; i < docLen; ++i) {
            try {
                if (sb.substring(i, i + searchLen).equals(search)) {
                    count++;
                    i += searchLen - 1;
                }
            } catch (Exception e) {
                break;
            }
        }
        return count;
    }
}
