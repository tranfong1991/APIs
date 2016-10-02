package andytran.apis.services.string;

import org.springframework.stereotype.Service;

@Service
public class StringServiceImpl implements StringService {
	
	public String reverse(String str){
		if(str == null)
			return null;
		if(str.isEmpty())
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
	
}
