import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class MinDifference {
	
	public int closestElements(int A0, int X, int Y, int M, int n) {
		int[] A = new int[n];
		A[0] = A0;
		for(int i = 1; i < A.length; ++i) {
			A[i] = (A[i - 1] * X + Y) % M;
		}

		Arrays.sort(A);
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < A.length; i++) {
			min = Math.min(min, Math.abs(A[i] - A[i - 1]));
		}
		return min;
	}
}
