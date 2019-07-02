import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class MorselikeCode {
	
	public String decrypt(String[] library, String message) {
		Map<String, String> m = new HashMap<>();

		for(int i = 0; i < library.length; ++i) {
			String[] le = library[i].split(" ");
			m.put(le[1], le[0]);
		}

		String[] mess = message.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < mess.length; ++i) {
			if (m.containsKey(mess[i])) {
				sb.append(m.get(mess[i]));
			} else {
				sb.append("?");
			}
		}
		return sb.toString();
	}
}
