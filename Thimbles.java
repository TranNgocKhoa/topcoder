import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Thimbles {
	
	public int thimbleWithBall(String[] swaps) {
		int ball = 1;

		for(int i = 0; i < swaps.length; i++) {
			int p1 = swaps[i].charAt(0) - '0';
			int p2 = swaps[i].charAt(2) - '0';
			if (p1 == ball) {
				ball = p2;
			} else if (p2 == ball){
				ball = p1;
			}
		}

		return ball;
	}


}
