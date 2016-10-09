package andytran.apis.services.string;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import andytran.apis.utils.StringConstants;

@Service
public class StringServiceImpl implements StringService {
	
	@Override
	public String reverse(String str){
		if(str == null)
			return null;
		if(str.isEmpty() || str.length() == 1)
			return str;
		
		StringBuilder reverseStr = new StringBuilder(str);
		int start = 0;
		int end = str.length() - 1;
		
		while(start < end){
			reverseStr.setCharAt(start, str.charAt(end));
			reverseStr.setCharAt(end, str.charAt(start));
			start++;
			end--;
		}
		
		return reverseStr.toString();
	}

	@Override
	public Boolean isPalindrome(String str) {
		if(str == null || str.isEmpty())
			return true;
		
		int start = 0;
		int end = str.length() - 1;
		
		while(start < end){
			if(str.charAt(start) != str.charAt(end))
				return false;
			start++;
			end--;
		}
		
		return true;
	}

	@Override
	public String pigLatin(String str) {
		if(str == null || str.isEmpty())
			return str;
		
		//find number of leading consonants
		int start = 0;
		while(true){
			char c = str.charAt(start);
			if(StringConstants.VOWELS.contains(String.valueOf(c)))
				break;
			start++;
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(str.substring(start));
		if(start == 0)
			stringBuilder.append("w");
		else
			stringBuilder.append(str.substring(0, start));
		stringBuilder.append("ay");
		
		return stringBuilder.toString();
	}

	@Override
	public String longestSubstring(String str) {
		if(str == null)
			return null;
		if(str.isEmpty() || str.length() == 1)
			return str;
		
		int curMaxLength = 0;
		String curLongestSubstr = null;
		Map<Character, Integer> charMap = new HashMap<>();
		
		for(int i = 0, j = 0; j < str.length(); j++){
			int oldMaxLength = curMaxLength;
			Character curChar = str.charAt(j);
			
			if(charMap.containsKey(curChar))
				i = Math.max(i, charMap.get(curChar) + 1);
			
			charMap.put(curChar, j);		
			curMaxLength = Math.max(curMaxLength, j - i + 1);
			if(curMaxLength > oldMaxLength)
				curLongestSubstr = str.substring(i, j + 1);
		}
				
		return curLongestSubstr;
	}
	
}
