import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class SearchBox {

    public int find(String text, String search, String wholeWord, int start) {
        if (wholeWord.equals("N")) {
            int i = findString(text.substring(start), search);
            return i == -1 ? -1 : i + start;
        } else {
            int i = findString(text.substring(start), search, true);
            return i == -1 ? -1 : i + start;
        }

    }

    private int findString(String text, String search) {
        for (int i = 0; i < text.length() - search.length(); i++) {
            if (text.substring(i, i + search.length()).equals(search)) {
                return i;
            }
        }
        return -1;
    }
    private int findString(String text, String search, boolean hole) {
        for (int i = 0; i < text.length() - search.length(); i++) {
            if (text.substring(i, i + search.length()).equals(search)) {
                if (text.charAt(i + search.length()) == ' ' || i == 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}
