import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class OptimalList {
	
	public String optimize(String inst) {
		int[] targetCoordinate = new int[] {0, 0};
		for(int i = 0; i < inst.length(); i++){
			char direct = inst.charAt(i);
			switch (direct) {
				case 'N':
					targetCoordinate[1] ++;
					break;
				case 'S':
					targetCoordinate[1] --;
					break;
				case 'E':
					targetCoordinate[0] ++;
					break;
				case 'W':
					targetCoordinate[0] --;
					break;
			}
		}
		StringBuilder sb = new StringBuilder();
		if (targetCoordinate[0] > 0) {
			sb.append(this.appendDirect('E', targetCoordinate[0]));
			if (targetCoordinate[1] > 0) {
				sb.append(this.appendDirect('N', targetCoordinate[1]));
			} else {
				sb.append(this.appendDirect('S', -1 * targetCoordinate[1]));
			}
		} else {
			if (targetCoordinate[1] > 0) {
				sb.append(this.appendDirect('N', targetCoordinate[1]));
			} else {
				sb.append(this.appendDirect('S', -1 * targetCoordinate[1]));
			}
			sb.append(this.appendDirect('W', -1*targetCoordinate[0]));
		}
		return sb.toString();
	}
	private String appendDirect(char direct, int number) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < number ; i++) {
			sb.append(direct);
		}
		return sb.toString();
	}

}
