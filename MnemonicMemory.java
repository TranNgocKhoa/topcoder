import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class MnemonicMemory {

    public String getPhrase(String number, String[] dictionary) {
        Arrays.sort(dictionary);
        StringBuilder sb = new StringBuilder();
        int[] count = new int[9];

        for (int i = 0; i < number.length(); ++i) {
            int c = 0;
            for (int j = 0; j < dictionary.length; j++) {
                if ((int) number.charAt(i) - '0' == dictionary[j].length()) {
                    if (count[(int) number.charAt(i) - '0' - 1] == c) {
                        sb.append(dictionary[j]);
                        sb.append(" ");
                        count[(int) number.charAt(i) - '0' - 1] = ++c;
                        break;

                    }
                    c++;
                }
            }
        }
        return sb.toString().trim();
    }
}
