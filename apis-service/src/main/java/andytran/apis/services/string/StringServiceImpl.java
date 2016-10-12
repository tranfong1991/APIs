package andytran.apis.services.string;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import andytran.apis.models.Pair;
import andytran.apis.models.Trie;
import andytran.apis.utils.StringConstants;
import andytran.apis.utils.StringUtils;

@Service
public class StringServiceImpl implements StringService {
	
	private Trie dictionary;
	private Map<Pair<Character, Character>, List<String>> wordListCache;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	public StringServiceImpl(){
		this.wordListCache = new HashMap<>();
	}
	
	@PostConstruct
	public void init() throws IOException{
		Resource resource = resourceLoader.getResource("classpath:dictionary.txt");
		this.dictionary = StringUtils.createTrieWithFile(resource.getFile());
	}
	
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
	public String longestNonRepeatingSubstring(String str) {
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

	@Override
	public List<String> unscramble(String str) {		
		if(str == null || str.isEmpty())
			return null;
		
		Pair<Character, Character> charPair = new Pair<>(str.charAt(0), str.charAt(str.length() - 1));
		List<String> qualifiedWords;
		
		//get a list of words that start with str.charAt(0) and end with str.charAt(str.length() - 1)
		if(wordListCache.containsKey(charPair))
			qualifiedWords = wordListCache.get(charPair);
		else {
			qualifiedWords = StringUtils.searchTrie(str.charAt(0), str.charAt(str.length() - 1), dictionary);
			wordListCache.put(charPair, qualifiedWords);
		}
		
		ArrayList<String> results = new ArrayList<>();
		if(qualifiedWords.isEmpty())
			return results;
		
		qualifiedWords.forEach(word -> {
			if(word.length() == 2){
				results.add(word);
				return;
			}
			
			int strIndex = 1;
			for(int i = 1; i < word.length() - 1; i++){
				boolean hasChar = false;
				for(; strIndex < str.length() - 1; strIndex++){
					if(str.charAt(strIndex) == word.charAt(i)){
						hasChar = true;
						break;
					}
				}	
				
				if(!hasChar)
					break;
				
				if(hasChar && i == word.length() - 2)
					results.add(word);
			}
		});
		
		return results;
	}

	@Override
	public List<String> dankify(String str) {
		if(str == null || str.isEmpty())
			return null;
		
		str = str.replaceAll("\\s+","").toLowerCase();
		
		//for saving unique words
		Map<String, Boolean> dankifiedWords = new HashMap<>();
		Comparator<String> comparator = new Comparator<String>(){
	        @Override
	        public int compare(String o1, String o2){
	            if(o1.length() > o2.length())
	                return -1;

	            if(o2.length() > o1.length())
	                return 1;

	            return 0;
	        }
	    };
		
		int curMaxLength = 0;
		for(int i = 0; i < str.length(); i++){
			for(int j = str.length() - 1; j > i; j--){
				//if the length of the substring is smaller than the longest word, then no need to check
				if(j - i + 1 < curMaxLength)
					break;
								
				List<String> unscrambledWords = unscramble(str.substring(i, j + 1));
				if(unscrambledWords.isEmpty())
					continue;
				
				Collections.sort(unscrambledWords, comparator);
				for(String word : unscrambledWords){
					if(dankifiedWords.containsKey(word))
						continue;
					
					if(word.length() >= curMaxLength){
						dankifiedWords.put(word, true);
						curMaxLength = word.length();
					} else break;
				}
			}
		}
		
		List<String> filteredDankifiedWords = new ArrayList<>();
		for(String word : dankifiedWords.keySet()){
			if(word.length() >= curMaxLength){
				filteredDankifiedWords.add(word);
				curMaxLength = word.length();
			}
		}
		
		return filteredDankifiedWords;
	}
	
}
