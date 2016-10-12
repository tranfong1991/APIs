package andytran.apis.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Set;

import andytran.apis.models.Trie;
import andytran.apis.models.TrieNode;

public final class StringUtils {
	
	private StringUtils(){}
	
	public static Trie createTrieWithFile(File file){
		Trie trie = new Trie();
		
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			String curLine;
			while((curLine = reader.readLine()) != null){
				trie.addWord(curLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return trie;
	}
	
	public static List<String> searchTrie(Character firstChar, Character lastChar, Trie trie){
		List<String> qualifiedWords = new ArrayList<>();
		
		if(firstChar == null || lastChar == null || trie == null)
			return qualifiedWords;
		
		TrieNode firstCharNode = trie.getRoot().getTrieNode(firstChar);
		//in case the trie does not have words that start with firstChar
		if(firstCharNode == null)
			return qualifiedWords;
		
		//do DFS on the trie to find words that start with firstChar and end with lastChar
		Deque<TrieNode> deque = new ArrayDeque<>();
		deque.push(firstCharNode);
		while(!deque.isEmpty()){
			TrieNode curNode = deque.pop();
			String curWord = curNode.getWord();
			if(curWord.charAt(curWord.length() - 1) == lastChar 
					&& curNode.isEndOfWord()){
				qualifiedWords.add(curWord);
			}
			
			Set<Character> keys = curNode.getMap().keySet();
			for(Character c : keys){
				deque.push(curNode.getTrieNode(c));
			}
		}
		
		return qualifiedWords;
	}
	
}
