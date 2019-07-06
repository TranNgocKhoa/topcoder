import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class AttendanceShort {

    public String[] shortList(String[] names, String[] attendance) {
        StringBuilder pass = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            int A = 0;
            int P = 0;
            for (int j = 0; j < attendance[i].length(); j++) {
                switch (attendance[i].charAt(j)) {
                    case 'A':
                        A++;
                        break;
                    case 'P':
                        P++;
                        break;
                }
            }
            if (P / ((double) A + P) < 0.75) {
                pass.append(names[i]);
                pass.append(" ");
            }
        }
        return Arrays.stream(pass.toString().trim().split(" ")).filter(x -> !x.isEmpty()).toArray(String[]::new);
    }
}
