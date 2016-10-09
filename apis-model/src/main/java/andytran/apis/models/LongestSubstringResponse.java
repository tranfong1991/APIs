package andytran.apis.models;

public class LongestSubstringResponse {
	
	private int length;
	private String substring;
	
	public LongestSubstringResponse(String substring){
		this.length = substring.length();
		this.substring = substring;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getSubstring() {
		return substring;
	}

	public void setSubstring(String substring) {
		this.substring = substring;
	}
	
}
