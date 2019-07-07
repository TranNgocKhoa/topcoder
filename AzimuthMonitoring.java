import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class AzimuthMonitoring {

    public int getAzimuth(String[] instructions) {
        int amuz = 0;
        for (int i = 0; i < instructions.length; i++) {
            if (instructions[i].contains("LEFT")) {
                if (instructions[i].length() > 4) {
                    amuz -= Integer.parseInt(instructions[i].substring(instructions[i].indexOf(' ') + 1));
                } else {
                    amuz -= 90;
                }
            } else if (instructions[i].contains("RIGHT")) {
                if (instructions[i].length() > 5) {
                    amuz += Integer.parseInt(instructions[i].substring(instructions[i].indexOf(' ') + 1));
                } else {
                    amuz += 90;
                }
            } else if (instructions[i].contains("TURN AROUND")) {
                amuz += 180;
            } else {
                break;
            }
        }
        return (amuz) >= 0 ? (amuz % 360) : 180 + Math.abs(amuz % 360);
    }
}
