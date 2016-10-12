package andytran.apis.services.string;

import java.util.List;

public interface StringService {
	String reverse(String str);
	Boolean isPalindrome(String str);
	String pigLatin(String str);
	String longestNonRepeatingSubstring(String str);
	List<String> unscramble(String str);
	List<String> dankify(String str);
}
