package andytran.apis.services.string;

import java.util.List;

public interface StringService {
	String reverse(String str);
	Boolean isPalindrome(String str);
	String pigLatin(String str);
	String longestSubstring(String str);
	List<String> unscramble(String str);
}
