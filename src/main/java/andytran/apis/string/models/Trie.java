package andytran.apis.string.models;

public class Trie {
	
	private TrieNode root;
	
	public Trie(){
		root = new TrieNode();
	}

	public TrieNode getRoot() {
		return root;
	}

	public void setRoot(TrieNode root) {
		this.root = root;
	}
	
	public boolean hasPrefix(String prefix){
		if(prefix == null || prefix.isEmpty())
			return false;
		
		TrieNode curNode = root;
		for(int i = 0; i < prefix.length(); i++){
			Character c = prefix.charAt(i);
			if(!curNode.hasTrieNode(c))
				return false;
			curNode = curNode.getTrieNode(c);
		}
		return true;
	}
	
	public boolean hasWord(String word){
		if(word == null || word.isEmpty())
			return false;
		
		TrieNode curNode = root;
		for(int i = 0; i < word.length(); i++){
			Character c = word.charAt(i);
			if(!curNode.hasTrieNode(c))
				return false;
			
			curNode = curNode.getTrieNode(c);
			if(i == word.length() - 1 && curNode.isEndOfWord())
				return true;
		}
		return false;
	}
	
	public void addWord(String word){
		if(word == null || word.isEmpty() || hasWord(word))
			return;
		
		TrieNode curNode = root;
		for(int i = 0; i < word.length(); i++){
			Character c = word.charAt(i);
			TrieNode nextNode;
			
			if(!curNode.hasTrieNode(c)){
				nextNode = new TrieNode(curNode.getWord() != null ? curNode.getWord() + c : Character.toString(c));			
				curNode.addTrieNode(c, nextNode);
			} else {
				nextNode = curNode.getTrieNode(c);
			}
			
			if(i == word.length() - 1)
				nextNode.setEndOfWord(true);
			curNode = nextNode;
		}
	}
	
	public void removeWord(String word){
		
	}
	
}
