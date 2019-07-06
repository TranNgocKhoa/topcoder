import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class EllipseCoverage {
	
	public int calculateCoverage(int x1, int y1, int x2, int y2, int d) {
		int count = 0;
		for (int i = -2*d; i < 2*d; i++) {
			for (int j = -2*d; j < 2*d; j++) {
				if (distance(i, j, x1, y1) + distance(i, j, x2, y2) < d) {
					count ++;
				}
			}
		}
		return count;
	}

	private double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
	}
}
