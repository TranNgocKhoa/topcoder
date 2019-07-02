import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class GuessingNextElement {
	
	public int guess(int[] A) {
//		int next = A[A.length - 1] * (A[1] / A[0]);
//		for(int i = 0; i < 2; i++) {
//			if (A[i+1] % A[i] != 0) {
//				next = A[A.length - 1] + (A[1] - A[0]);
//				break;
//			}
//		}
//		return next;

		if (A[A.length - 1] - A[A.length - 2] == A[A.length - 2] - A[A.length - 3]) {
			return A[A.length - 1] + (A[1] - A[0]);
		} else {
			return A[A.length - 1] * (A[1] / A[0]);
		}
	}
}
