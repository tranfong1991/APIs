package andytran.apis.models;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	
	private String word;
	private Map<Character, TrieNode> map;
	private boolean endOfWord;
	
	public TrieNode(){
		this.word = null;
		this.map = new HashMap<>();
		this.endOfWord = false;
	}
	
	public TrieNode(String word){
		this();
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Map<Character, TrieNode> getMap() {
		return map;
	}

	public void setMap(Map<Character, TrieNode> map) {
		this.map = map;
	}

	public boolean isEndOfWord() {
		return endOfWord;
	}

	public void setEndOfWord(boolean endOfWord) {
		this.endOfWord = endOfWord;
	}
	
	public boolean hasTrieNode(Character c){
		if(c == null)
			return false;
		
		return map.containsKey(c);
	}
	
	public TrieNode getTrieNode(Character c){
		if(c == null)
			return null;
		
		return map.get(c);
	}
	
	public void addTrieNode(Character c, TrieNode node){
		if(c == null || node == null)
			return;
		
		map.put(c, node);
	}
	
	public void removeTrieNode(Character c){
		if(c == null)
			return;
		
		map.remove(c);
	}
	
}
