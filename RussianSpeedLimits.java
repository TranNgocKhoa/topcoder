import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class RussianSpeedLimits {
	
	public int getCurrentLimit(String[] signs) {
		int limit = 60;
		boolean inside = true;
		for(int i = 0; i < signs.length; i++) {
			if (signs[i].equals("city")) {
				inside = !inside;
				limit = inside ? 60 : 90;
			} else if (signs[i].equals("default")) {
				limit = inside ? 60 : 90;
			} else {
				limit = Integer.parseInt(signs[i]);
			}
		}
		return limit;
	}
}
