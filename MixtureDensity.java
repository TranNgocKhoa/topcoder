import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class MixtureDensity {

    public double getDensity(String[] ingredients) {
        int weigth = 0;
        int volume = 0;
        for (int i = 0; i < ingredients.length; ++i) {
            ingredients[i] = ingredients[i].replaceAll("[^0-9\\s]", "");
            String[] arSplit = ingredients[i].split("\\s+");
            weigth += Integer.parseInt(arSplit[1]);
            volume += Integer.parseInt(arSplit[0]);
        }

        return (double) weigth / volume;
    }
}
