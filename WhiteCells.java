import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class WhiteCells {

    public int countOccupied(String[] board) {
        //a[i][j] : if i - j % 2 == 0: White else Black
        int count = 0;
        for (int i = 0; i < board.length; ++i) {
            char[] row = board[i].toCharArray();
            for (int j = 0; j < row.length; ++j) {
                if (row[j] == 'F' && (i - j) % 2 == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
