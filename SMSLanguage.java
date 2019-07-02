import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class SMSLanguage {
	
	public String translate(String text) {
		String[] replaceBy = new String[] { "",  "&", "8", "@", "U"};
		String[] replace = new String[] { "[.,?!]", "and", "ate", "at", "you"};

		text = text.toLowerCase();
		for(int i = 0; i < replace.length; ++i) {
			text = text.replaceAll(replace[i], replaceBy[i]);
		}
		return text;
	}
}
